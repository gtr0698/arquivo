package com.arquivo.csv.arquivo.component;

import com.arquivo.csv.arquivo.model.Enroll;
import com.arquivo.csv.arquivo.repository.EnrollRepository;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class EnrollComponent {

    @Autowired
    private EnrollRepository enrollRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

    @Scheduled(cron = ("0 23,53 * * * *"), zone = "America/Sao_Paulo")
    public void enrollCsv() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Enroll> pessoas = enrollRepository.findAll();

        Writer writer = Files.newBufferedWriter(Paths.get("enroll_" + dateFormat.format(new Date()) + ".csv"));
        StatefulBeanToCsv<Enroll> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(pessoas);

        writer.flush();
        writer.close();

    }

}
