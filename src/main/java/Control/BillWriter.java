/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

/**
 *
 * @author felip
 */
public class BillWriter {
    
    private final String path;
    
    public BillWriter(String path){
        this.path = path;
    }
    
    public void generateBill(User customer) {
        
        Car vehicle = customer.getVehicle();
        Paragraph title = createTitle();
        Paragraph header = createHeader();
        Paragraph userData = createUserdata(customer);
        PdfPTable vehicleTable = createVehicleTable(vehicle);
        Paragraph totalSection = createTotal(vehicle.getPrice());
        
        try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(title);

            
            document.add(header);

            
            document.add(userData);

            document.add(new Paragraph("Datos del Vehículo:"));
            document.add(vehicleTable);
            document.add(new Chunk(createSeparator()));
            document.add(Chunk.NEWLINE);
            
            document.add(totalSection);

            document.close();

            System.out.println("La factura ha sido generada exitosamente en el archivo: " + path);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private LineSeparator createSeparator() {
        LineSeparator line = new LineSeparator();
        line.setLineColor(BaseColor.LIGHT_GRAY);
        line.setLineWidth(1f);
        return line;
    }
    
    private Paragraph createHeader() {
        String companyName = "Concesionario El Minino";
        String companyAddress = "Pozo Principal, bosque XYZ";
        String companyPhone = "123-456-789";
        String companyEmail = "info@elminino.com";
        String companyWebsite = "www.concesionarioelminino.com";
        String companyNit = "NIT: 123456789";
        
        Paragraph header = new Paragraph();
        header.add(new Paragraph(companyName, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK)));
        header.add(new Paragraph(companyAddress));
        header.add(new Paragraph(companyPhone));
        header.add(new Paragraph(companyEmail));
        header.add(new Paragraph(companyWebsite));
        header.add(new Paragraph(companyNit));
        header.add(new Chunk(createSeparator()));
        header.add(Chunk.NEWLINE);
        return header;
    }
    
    private Paragraph createUserdata(User customer) {
        String customerName = customer.getName();
        String customerAddress = "Avenida Principal, Ciudad A";
        String customerPhone = "987-654-321";
        String customerEmail = customerName.replace(" ", "_") + "@email.com";
        
        Paragraph userData = new Paragraph();
        userData.add(new Paragraph("Datos del Cliente:"));
        userData.add(new Paragraph("Nombre: " + customerName));
        userData.add(new Paragraph("Dirección: " + customerAddress));
        userData.add(new Paragraph("Teléfono: " + customerPhone));
        userData.add(new Paragraph("Email: " + customerEmail));
        userData.add(new Chunk(createSeparator()));
        userData.add(Chunk.NEWLINE);
        return userData;
    }
    
    private PdfPTable createVehicleTable(Car vehicle) {
        Random r = new Random();
        String[] colors = {"Rojo", "Azul", "Verde", "Negro", "Blanco", "Gris", "Naranja", "Morado", "Amarillo"};
        
        String vehicleBrand = vehicle.getBrand();
        String vehicleModel = vehicle.getReference();
        String vehicleColor = colors[r.nextInt(9)];
        String productionYear = "2023";
        String fuelType = "Gasolina";
        String engineNumber = "123456789";
        
        PdfPTable vehicleTable = new PdfPTable(2);
        vehicleTable.setWidthPercentage(100);
        vehicleTable.setSpacingBefore(10f);
        vehicleTable.setSpacingAfter(10f);
            
        vehicleTable.addCell("Marca:");
        vehicleTable.addCell(vehicleBrand);
        vehicleTable.addCell("Modelo:");
        vehicleTable.addCell(vehicleModel);
        vehicleTable.addCell("Color:");
        vehicleTable.addCell(vehicleColor);
        vehicleTable.addCell("Año de Fabricación:");
        vehicleTable.addCell(productionYear);
        vehicleTable.addCell("Tipo de Combustible:");
        vehicleTable.addCell(fuelType);
        vehicleTable.addCell("Número de Motor:");
        vehicleTable.addCell(engineNumber);
        
        return vehicleTable;
    }
    
    private Paragraph createTitle() {
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Paragraph title = new Paragraph("Factura", titleFont);
        title.setAlignment(Element.ALIGN_LEFT);
        title.setSpacingAfter(20f);
        return title;
    }
    
    private Paragraph createTotal(double price) {
        double subtotal = price;
        double taxes = TaxCalculator.calculateIva(subtotal);
        double total = subtotal + taxes;
        Paragraph totalSection = new Paragraph();
        totalSection.add(new Paragraph("Subtotal: $" + subtotal));
        totalSection.add(new Paragraph("Impuestos: $" + taxes));
        totalSection.add(new Paragraph("Total a Pagar: $" + total));
        totalSection.add(new Chunk(createSeparator()));
        return totalSection;
    }
}
