package com.app.school.service.impl;

import com.app.school.enums.Gender;
import com.app.school.enums.Month;
import com.app.school.model.Fee;
import com.app.school.model.Student;
import com.app.school.service.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

@Service
public class ImportFileService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private FeeService feeService;

    @Autowired
    private SessionService sessionService;

    public void readExcelAndSaveStudentData(MultipartFile file, Long sessionId) {
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);  // Read the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                    continue; // Skip header row
                }

                DataFormatter formatter = new DataFormatter();

                String firstName = row.getCell(0).getStringCellValue();
                String middleName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                String dob = formatter.formatCellValue(row.getCell(3));
                String gender = row.getCell(4).getStringCellValue();
                String standard = row.getCell(5).getStringCellValue(); // Class IV
                String rollNo = formatter.formatCellValue(row.getCell(6));
                String uDiasCode = formatter.formatCellValue(row.getCell(7));
                String previousSchool = row.getCell(8).getStringCellValue();
                String mobile = formatter.formatCellValue(row.getCell(9));
                String email = row.getCell(10).getStringCellValue();
                String landline = formatter.formatCellValue(row.getCell(11));
                String state = row.getCell(12).getStringCellValue();
                String city = row.getCell(13).getStringCellValue();
                String pincode = formatter.formatCellValue(row.getCell(14));
                String address = row.getCell(15).getStringCellValue();
                String vehicle = row.getCell(16).getStringCellValue();
                Boolean uniform = row.getCell(17).getBooleanCellValue();
                Boolean course = row.getCell(18).getBooleanCellValue();
                Boolean tc = row.getCell(19).getBooleanCellValue();
                Boolean marksheet = row.getCell(20).getBooleanCellValue();
                Boolean aadhar = row.getCell(21).getBooleanCellValue();
                Boolean parentAadhar = row.getCell(22).getBooleanCellValue();
                Boolean photo = row.getCell(23).getBooleanCellValue();
                Boolean dobCertificate = row.getCell(24).getBooleanCellValue();
                // need to check parents and picture


                Student student = new Student();
                student.setFirstName(firstName);
                student.setMiddleName(middleName);
                student.setLastName(lastName);
                student.setDob(dob);
                student.setGender(Gender.valueOf(gender.toUpperCase()));

                Long standardId = standardService.getStandardByName(standard).getId();
                student.setStandardId(standardId);

                student.setRollNo(Integer.parseInt(rollNo));
                student.setuDiasCode(uDiasCode);
                student.setPreviousSchool(previousSchool);
                student.setMobile(mobile);
                student.setEmail(email);
                student.setLandline(landline);
                student.setState(state);
                student.setCity(city);
                student.setPincode(Integer.parseInt(pincode));
                student.setAddress(address);
                student.setUniform(uniform);
                student.setCourse(course);
                student.setDocTC(tc);
                student.setDocMarksheet(marksheet);
                student.setDocAadhar(aadhar);
                student.setDocParentAadhar(parentAadhar);
                student.setDocPhotograph(photo);
                student.setDocDobCertificate(dobCertificate);

                Long vehicleId = vehicleService.getVehicleByName(vehicle).getId();
                student.setVehicleId(vehicleId);
                // Set other fields

                studentService.addStudent(student, true, sessionId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readExcelAndSaveFeesData(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);  // Read the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                    continue; // Skip header row
                }

                DataFormatter formatter = new DataFormatter();

                Long id = (long) row.getCell(0).getNumericCellValue();
                String uDiasCode = row.getCell(1).getStringCellValue();
                String month = row.getCell(2).getStringCellValue();
                String date = formatter.formatCellValue(row.getCell(3));
                Double registration = row.getCell(4).getNumericCellValue();
                Double monthly = row.getCell(5).getNumericCellValue();
                Double van = row.getCell(6).getNumericCellValue();
                Double course = row.getCell(7).getNumericCellValue();
                Double copies = row.getCell(8).getNumericCellValue();
                Double diary = row.getCell(9).getNumericCellValue();
                Double shoes = row.getCell(10).getNumericCellValue();
                Double socks = row.getCell(11).getNumericCellValue();
                Double tieBelt = row.getCell(12).getNumericCellValue();
                Double other = row.getCell(13).getNumericCellValue();
                Double total = row.getCell(14).getNumericCellValue();
                Double deposited = row.getCell(15).getNumericCellValue();
                String session = row.getCell(16).getStringCellValue();

                Fee fee = new Fee();
                fee.setId(id);

                Long studentId = studentService.getStudentByCode(uDiasCode).getId();
                fee.setStudentId(studentId);

                fee.setMonth(Month.valueOf(month));
                fee.setDate(LocalDateTime.parse(date));
                fee.setRegistration(registration);
                fee.setMonthly(monthly);
                fee.setVan(van);
                fee.setCourse(course);
                fee.setCopies(copies);
                fee.setDiary(diary);
                fee.setShoes(shoes);
                fee.setSocks(socks);
                fee.setTieBelt(tieBelt);
                fee.setOther(other);
                fee.setTotal(total);
                fee.setDeposited(deposited);

                Long sessionId = sessionService.getSessionByName(session).getId();
                fee.setSessionId(sessionId);

                feeService.addFees(fee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void readExcelAndSaveMarksData(MultipartFile file) {
//
//    }
}
