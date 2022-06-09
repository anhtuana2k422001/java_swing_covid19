
package Controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhapXuatExcel {

    public void exportExcel(JTable table) {
        try {
            JFileChooser fchooser = new JFileChooser();
            fchooser.showSaveDialog(fchooser);
            File saveFile = fchooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("ThongKe");

                XSSFRow row = sheet.createRow(0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    XSSFCell cell = row.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }

                for (int j = 0; j < table.getRowCount(); j++) {
                    row = sheet.createRow(j + 1);
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        XSSFCell cell = row.createCell(k);
                        if (table.getValueAt(j, k) != null) {
                            cell.setCellValue(table.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                openFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Hủy thao tác xuất Excel!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

  
}
