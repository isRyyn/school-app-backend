package com.app.school.service.impl;

import com.app.school.enums.Gender;
import com.app.school.enums.Month;
import com.app.school.model.Fee;
import com.app.school.model.Student;
import com.app.school.model.Vehicle;
import com.app.school.service.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

                if (isRowEmpty(row)) {
                    break;
                }

                DataFormatter formatter = new DataFormatter();

                String firstName = getCellValueAsString(row.getCell(0));
                String middleName = getCellValueAsString(row.getCell(1));
                String lastName = getCellValueAsString(row.getCell(2));
                String dob = formatter.formatCellValue(row.getCell(3));
                String gender = getCellValueAsString(row.getCell(4));
                String standard = getCellValueAsString(row.getCell(5)); // Class IV
                String rollNo = formatter.formatCellValue(row.getCell(6));
                String uDiasCode = formatter.formatCellValue(row.getCell(7));
                String previousSchool = getCellValueAsString(row.getCell(8));
                String mobile = formatter.formatCellValue(row.getCell(9));
                String email = getCellValueAsString(row.getCell(10));
                String landline = formatter.formatCellValue(row.getCell(11));
                String state = getCellValueAsString(row.getCell(12));
                String city = getCellValueAsString(row.getCell(13));
                String pincode = formatter.formatCellValue(row.getCell(14));
                String address = getCellValueAsString(row.getCell(15));
                String vehicle = getCellValueAsString(row.getCell(16));
                Boolean uniform = Boolean.valueOf(formatter.formatCellValue(row.getCell(17)));
                Boolean course = Boolean.valueOf(formatter.formatCellValue(row.getCell(18)));
                Boolean tc = Boolean.valueOf(formatter.formatCellValue(row.getCell(19)));
                Boolean marksheet = Boolean.valueOf(formatter.formatCellValue(row.getCell(20)));
                Boolean aadhar = Boolean.valueOf(formatter.formatCellValue(row.getCell(21)));
                Boolean parentAadhar = Boolean.valueOf(formatter.formatCellValue(row.getCell(22)));
                Boolean photo = Boolean.valueOf(formatter.formatCellValue(row.getCell(23)));
                Boolean dobCertificate = Boolean.valueOf(formatter.formatCellValue(row.getCell(24)));

                Long id = null;
                if(row.getCell(25) != null &&  row.getCell(25).getCellType() != CellType.BLANK) {
                    id = (long) row.getCell(0).getNumericCellValue();
                }
                // need to check parents and picture


                Student student = new Student();
                if(id != null) {
                    student.setId(id);
                } else {
                    student.setId(null);
                }

                student.setFirstName(firstName);
                student.setMiddleName(middleName);
                student.setLastName(lastName);
                student.setDob(dob);
                student.setGender(Gender.valueOf(gender.toUpperCase()));

                Long standardId = standardService.getStandardByName(standard).getId();
                student.setStandardId(standardId);

                student.setRollNo(rollNo != "" ? Integer.parseInt(rollNo) : null);
                student.setuDiasCode(uDiasCode);
                student.setPreviousSchool(previousSchool);
                student.setMobile(mobile);
                student.setEmail(email);
                student.setLandline(landline);
                student.setState(state);
                student.setCity(city);
                student.setPincode(pincode != "" ? Integer.parseInt(pincode) : null);
                student.setAddress(address);
                student.setUniform(uniform);
                student.setCourse(course);
                student.setDocTC(tc);
                student.setDocMarksheet(marksheet);
                student.setDocAadhar(aadhar);
                student.setDocParentAadhar(parentAadhar);
                student.setDocPhotograph(photo);
                student.setDocDobCertificate(dobCertificate);

                Vehicle v = vehicleService.getVehicleByName(vehicle);
                if(v != null) {
                    student.setVehicleId(v.getId());
                }



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

                if (isRowEmpty(row)) {
                    break;
                }

                DataFormatter formatter = new DataFormatter();

                Long id = null;
                if(row.getCell(0) != null &&  row.getCell(0).getCellType() != CellType.BLANK) {
                    id = (long) row.getCell(0).getNumericCellValue();
                }

                String uDiasCode = row.getCell(1).getStringCellValue();
                String month = row.getCell(2).getStringCellValue();
                String date = formatter.formatCellValue(row.getCell(3));
                Double registration = getCellValueAsNumber(row.getCell(4));
                Double monthly = getCellValueAsNumber(row.getCell(5));
                Double van = getCellValueAsNumber(row.getCell(6));
                Double course = getCellValueAsNumber(row.getCell(7));
                Double copies = getCellValueAsNumber(row.getCell(8));
                Double diary = getCellValueAsNumber(row.getCell(9));
                Double shoes = getCellValueAsNumber(row.getCell(10));
                Double socks = getCellValueAsNumber(row.getCell(11));
                Double tieBelt = getCellValueAsNumber(row.getCell(12));
                Double other = getCellValueAsNumber(row.getCell(13));
                Double total = getCellValueAsNumber(row.getCell(14));
                Double deposited = getCellValueAsNumber(row.getCell(15));
                String session = getCellValueAsString(row.getCell(16));

                Fee fee = new Fee();

                if(id != null) {
                    fee.setId(id);
                } else {
                    fee.setId(null);
                }

                Long studentId = studentService.getStudentByCode(uDiasCode).getId();
                fee.setStudentId(studentId);

                fee.setMonth(Month.valueOf(month));
                fee.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay());
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

    private static boolean isRowEmpty(Row row) {
        if (row == null) return true;
        for (Cell cell : row) {
            if (cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    private static Double getCellValueAsNumber(Cell cell) {
        if(cell == null) {
            return 0D;
        } else {
            return cell.getNumericCellValue();
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string if cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString(); // Handle date
                } else {
                    return String.valueOf(cell.getNumericCellValue()); // Handle numbers
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return ""; // Return empty string for blank cells
            default:
                return ""; // Handle other cases
        }
    }

//    public void readExcelAndSaveMarksData(MultipartFile file) {
//
//    }
}
