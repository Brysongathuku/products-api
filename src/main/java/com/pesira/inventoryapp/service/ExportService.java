package com.pesira.inventoryapp.service;

import com.pesira.inventoryapp.model.Product;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExportService {

    public String toCsv(List<Product> products) {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        StringBuilder sb = new StringBuilder("id,name,description,category,price,quantity,status,imageUrl,createdAt,updatedAt\n");
        for (Product p : products) {
            sb.append(p.getId()).append(',')
              .append(escape(p.getName())).append(',')
              .append(escape(p.getDescription())).append(',')
              .append(escape(p.getCategory())).append(',')
              .append(p.getPrice()).append(',')
              .append(p.getQuantity()).append(',')
              .append(escape(p.getStatus())).append(',')
              .append(escape(p.getImageUrl())).append(',')
              .append(p.getCreatedAt().format(fmt)).append(',')
              .append(p.getUpdatedAt().format(fmt))
              .append('\n');
        }
        return sb.toString();
    }

    private String escape(String value) {
        if (value == null) return "";
        String escaped = value.replace("\"", "\"\"");
        if (escaped.contains(",") || escaped.contains("\"") || escaped.contains("\n")) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}
