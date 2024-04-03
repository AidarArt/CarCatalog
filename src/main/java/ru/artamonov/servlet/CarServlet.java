package ru.artamonov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.artamonov.model.CarEntity;
import ru.artamonov.service.CarService;
import ru.artamonov.service.impl.CarServiceImpl;
import ru.artamonov.servlet.dto.CarIncomingDto;
import ru.artamonov.servlet.dto.CarOutGoingDto;
import ru.artamonov.servlet.dto.CreatorOutGoingDto;
import ru.artamonov.servlet.mapper.CarDtoMapper;
import ru.artamonov.servlet.mapper.impl.CarDtoMapperImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {

    private final CarService carService = new CarServiceImpl();
    private final CarDtoMapper carDtoMapper = new CarDtoMapperImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryParams = req.getQueryString();
        try (PrintWriter writer = resp.getWriter()) {
            if (queryParams == null) {
                for (CarEntity entity : carService.findAll()) {
                    entity.setCarCreators(carService.getCarCreators(entity.getCarId()));
                    CarOutGoingDto dto = carDtoMapper.map(entity);

                    writer.write("Car:\n");
                    writer.write("model=" + dto.getModel());
                    writer.write("\nbrand=" + dto.getBrand().getName() + " country=" + dto.getBrand().getCountry() + '\n');
                    writer.write("creators=");
                    for (CreatorOutGoingDto creator : dto.getCreators()) {
                        writer.write("{name:" + creator.getName() + " surname:" + creator.getSurname() + " profession:" + creator.getProfession() + '}');
                    }
                    writer.write('\n');
                }
            } else {
                Long id = Long.valueOf(req.getParameter("id"));
                CarEntity entity = carService.findById(id);
                entity.setCarCreators(carService.getCarCreators(id));
                CarOutGoingDto dto = carDtoMapper.map(entity);
                writer.write("Car:\n");
                writer.write("model=" + dto.getModel());
                writer.write("\nbrand=" + dto.getBrand().getName() + " country=" + dto.getBrand().getCountry() + '\n');
                writer.write("creators=");
                for (CreatorOutGoingDto creator : dto.getCreators()) {
                    writer.write("{name:" + creator.getName() + " surname:" + creator.getSurname() + " profession:" + creator.getProfession() + '}');
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            CarIncomingDto incomingDto = new CarIncomingDto();
            incomingDto.setId(-1L);
            incomingDto.setModel(req.getParameter("model"));
            incomingDto.setBrandId(Long.valueOf(req.getParameter("brand-id")));
            carService.save(carDtoMapper.map(incomingDto));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CarIncomingDto incomingDto = new CarIncomingDto();
            incomingDto.setId(Long.valueOf(req.getParameter("id")));
            incomingDto.setModel(req.getParameter("model"));
            incomingDto.setBrandId(Long.valueOf(req.getParameter("brand-id")));
            carService.update(carDtoMapper.map(incomingDto));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            carService.delete(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
