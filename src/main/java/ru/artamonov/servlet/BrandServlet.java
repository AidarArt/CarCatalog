package ru.artamonov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.artamonov.db.PostgreSQLConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.repository.impl.BrandRepositoryImpl;
import ru.artamonov.repository.mapper.BrandRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/brands")
public class BrandServlet extends HttpServlet {

    BrandRepository brandRepository = new BrandRepositoryImpl(new PostgreSQLConnectionManager());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        try (PrintWriter writer = resp.getWriter()) {
            List<BrandEntity> brands = brandRepository.findAll();
            writer.write("<h1>Автомобильные бренды</h1></hr>");
            writer.write("<ul>");
            for (BrandEntity entity : brands) {
                writer.write("<li><a href='brands/?id=" + entity.getBrandId() + "'>" + entity.getBrandName() + "</a></li>");
            }
            writer.write("</ul>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
