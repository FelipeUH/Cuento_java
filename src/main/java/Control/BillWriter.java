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
    
    private String ruta;
    
    public BillWriter(String ruta){
        this.ruta = ruta;
    }
    
    public void generarFactura(Usuario cliente) {
        
        Carro vehiculo = cliente.getVehiculo();
        Paragraph title = crearTitulo();
        Paragraph header = crearEncabezado();
        Paragraph userData = crearDatosUsuario(cliente);
        PdfPTable vehicleTable = crearTablaVehiculo(vehiculo);
        Paragraph totalSection = crearTotal(vehiculo.getPrecio());
        
        try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(ruta));

            document.open();

            document.add(title);

            
            document.add(header);

            
            document.add(userData);

            document.add(new Paragraph("Datos del Vehículo:"));
            document.add(vehicleTable);
            document.add(new Chunk(crearSeparador()));
            document.add(Chunk.NEWLINE);
            
            document.add(totalSection);

            document.close();

            System.out.println("La factura ha sido generada exitosamente en el archivo: " + ruta);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private LineSeparator crearSeparador() {
        LineSeparator line = new LineSeparator();
        line.setLineColor(BaseColor.LIGHT_GRAY);
        line.setLineWidth(1f);
        return line;
    }
    
    private Paragraph crearEncabezado() {
        String nombreEmpresa = "Concesionario El Minino";
        String direccionEmpresa = "Pozo Principal, bosque XYZ";
        String telefonoEmpresa = "123-456-789";
        String emailEmpresa = "info@elminino.com";
        String sitioWebEmpresa = "www.concesionarioelminino.com";
        String nitEmpresa = "NIT: 123456789";
        
        Paragraph header = new Paragraph();
        header.add(new Paragraph(nombreEmpresa, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK)));
        header.add(new Paragraph(direccionEmpresa));
        header.add(new Paragraph(telefonoEmpresa));
        header.add(new Paragraph(emailEmpresa));
        header.add(new Paragraph(sitioWebEmpresa));
        header.add(new Paragraph(nitEmpresa));
        header.add(new Chunk(crearSeparador()));
        header.add(Chunk.NEWLINE);
        return header;
    }
    
    private Paragraph crearDatosUsuario(Usuario cliente) {
        String nombreCliente = cliente.getNombre();
        String direccionCliente = "Avenida Principal, Ciudad A";
        String telefonoCliente = "987-654-321";
        String emailCliente = nombreCliente.strip() + "@email.com";
        Carro vehiculo = cliente.getVehiculo();
        
        Paragraph userData = new Paragraph();
        userData.add(new Paragraph("Datos del Cliente:"));
        userData.add(new Paragraph("Nombre: " + nombreCliente));
        userData.add(new Paragraph("Dirección: " + direccionCliente));
        userData.add(new Paragraph("Teléfono: " + telefonoCliente));
        userData.add(new Paragraph("Email: " + emailCliente));
        userData.add(new Chunk(crearSeparador()));
        userData.add(Chunk.NEWLINE);
        return userData;
    }
    
    private PdfPTable crearTablaVehiculo(Carro vehiculo) {
        Random r = new Random();
        String colores[] = {"Rojo", "Azul", "Verde", "Negro", "Blanco", "Gris", "Naranja", "Morado", "Amarillo"};
        
        String marcaVehiculo = vehiculo.getMarca();
        String modeloVehiculo = vehiculo.getReferencia();
        String colorVehiculo = colores[r.nextInt(9)];
        String añoFabricacion = "2023";
        String tipoCombustible = "Gasolina";
        String numeroMotor = "123456789";
        double precioVehiculo = vehiculo.getPrecio();
        
        PdfPTable vehicleTable = new PdfPTable(2);
        vehicleTable.setWidthPercentage(100);
        vehicleTable.setSpacingBefore(10f);
        vehicleTable.setSpacingAfter(10f);
            
        vehicleTable.addCell("Marca:");
        vehicleTable.addCell(marcaVehiculo);
        vehicleTable.addCell("Modelo:");
        vehicleTable.addCell(modeloVehiculo);
        vehicleTable.addCell("Color:");
        vehicleTable.addCell(colorVehiculo);
        vehicleTable.addCell("Año de Fabricación:");
        vehicleTable.addCell(añoFabricacion);
        vehicleTable.addCell("Tipo de Combustible:");
        vehicleTable.addCell(tipoCombustible);
        vehicleTable.addCell("Número de Motor:");
        vehicleTable.addCell(numeroMotor);
        
        return vehicleTable;
    }
    
    private Paragraph crearTitulo() {
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Paragraph title = new Paragraph("Factura", titleFont);
        title.setAlignment(Element.ALIGN_LEFT);
        title.setSpacingAfter(20f);
        return title;
    }
    
    private Paragraph crearTotal(double precio) {
        double subtotal = precio;
        double impuestos = CalculadoraImpuestos.calcularIva(subtotal);
        double total = subtotal + impuestos;
        Paragraph totalSection = new Paragraph();
        totalSection.add(new Paragraph("Subtotal: $" + subtotal));
        totalSection.add(new Paragraph("Impuestos: $" + impuestos));
        totalSection.add(new Paragraph("Total a Pagar: $" + total));
        totalSection.add(new Chunk(crearSeparador()));
        return totalSection;
    }
}
