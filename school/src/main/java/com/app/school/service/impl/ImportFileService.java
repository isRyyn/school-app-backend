package com.app.school.service.impl;

import com.app.school.enums.Gender;
import com.app.school.model.Student;
import com.app.school.repository.StudentRepository;
import com.app.school.repository.VehicleRepository;
import com.app.school.service.StandardService;
import com.app.school.service.StudentService;
import com.app.school.service.VehicleService;
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

@Service
public class ImportFileService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private VehicleService vehicleService;

    public void readExcelAndSaveData(MultipartFile file) {
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

                studentService.addStudent(student, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
