package ru.artamonov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.artamonov.model.CarEntity;
import ru.artamonov.service.CarService;
import ru.artamonov.service.impl.CarServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {

    private final CarService carService = new CarServiceImpl();
    private final CarDtoMapper carDtoMapper = new CarDtoMapperImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryParams = req.getQueryString();
        if (queryParams == null) {
            try (PrintWriter writer = resp.getWriter()){

                List<CarEntity> carEntityList = carService.findAll();

                for (CarEntity entity : carEntityList) {
                    writer.write(carDtoMapper.map(entity).toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (PrintWriter writer = resp.getWriter()) {
                Long id = Long.valueOf(req.getParameter("id"));
                writer.write(carDtoMapper.map(carService.findById(id)).toString());

            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        CarIncomingDto incomingDto = new CarIncomingDto();
        incomingDto.setCarModelName(req.getParameter("car-model"));
        incomingDto.setBrandName(req.getParameter("car-brand"));
        incomingDto.setBrandCountry(req.getParameter("car-country"));
        incomingDto.setCarBodyType(req.getParameter("car-bt"));
        incomingDto.setCarAccelerationTo100(req.getParameter("car-acc"));
        incomingDto.setCarTransmission(req.getParameter("car-trans"));
        incomingDto.setCarMaxSpeed(req.getParameter("car-max"));

        incomingDto.setEngineBrand(req.getParameter("engine-brand"));
        incomingDto.setEngineBrandCountry(req.getParameter("engine-brand-country"));
        incomingDto.setEngineCapacity(req.getParameter("engine-cap"));
        incomingDto.setEngineConsumption(req.getParameter("engine-con"));
        incomingDto.setEngineCylindersNumber(req.getParameter("engine-cyl"));
        incomingDto.setEngineHorsePower(req.getParameter("engine-hp"));
        incomingDto.setEngineType(req.getParameter("engine-type"));

        carService.save(carDtoMapper.map(incomingDto));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
