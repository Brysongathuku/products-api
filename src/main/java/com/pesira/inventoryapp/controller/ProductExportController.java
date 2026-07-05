package com.pesira.inventoryapp.controller;

import com.pesira.inventoryapp.dto.ProductResponse;
import com.pesira.inventoryapp.model.Product;
import com.pesira.inventoryapp.service.ExportService;
import com.pesira.inventoryapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/export")
@RequiredArgsConstructor
public class ProductExportController {

    private final ProductService productService;
    private final ExportService exportService;

    @GetMapping
    public ResponseEntity<?> export(@RequestParam(defaultValue = "json") String format) {
        List<Product> products = productService.findAllForExport();

        if ("csv".equalsIgnoreCase(format)) {
            String csv = exportService.toCsv(products);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.attachment().filename("products.csv").build());
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .body(csv);
        }

        List<ProductResponse> json = products.stream().map(ProductResponse::from).toList();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.attachment().filename("products.json").build());
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json);
    }
}
