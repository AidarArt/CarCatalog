package ru.artamonov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.service.BrandService;
import ru.artamonov.service.impl.BrandServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/brands")
public class BrandServlet extends HttpServlet {

    private final BrandService brandService = new BrandServiceImpl();
    private final BrandDtoMapper brandDtoMapper = new BrandDtoMapperImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String queryParams = req.getQueryString();
        if (queryParams == null) {
            try (PrintWriter writer = resp.getWriter()) {
                List<BrandEntity> brandEntities = brandService.findAll();

                for (BrandEntity entity : brandEntities) {
                    writer.write(brandDtoMapper.map(entity).toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (PrintWriter writer = resp.getWriter()) {
                Long id = Long.valueOf(req.getParameter("id"));

                writer.write(brandDtoMapper.map(brandService.findById(id)).toString());

            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String country = req.getParameter("country");

        brandService.save(brandDtoMapper.map(new BrandIncomingDto("0", name, country)));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String country = req.getParameter("country");

        BrandIncomingDto incomingDto = new BrandIncomingDto(id, name, country);

        brandService.update(brandDtoMapper.map(incomingDto));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            brandService.delete(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
}
