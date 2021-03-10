package ru.mirea.trpp_second_1.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trpp_second_1.entity.HealthResponse;

/** Проверка состояния сервера. */
@Controller()
public class HealthController {

    /**
     * Проверить состояние сервера.
     * @return ответ
     * 200 - OK
     */
    @Get
    public HttpResponse<HealthResponse> healthCheck() {
        return HttpResponse.ok(new HealthResponse("ok"));
    }
}
