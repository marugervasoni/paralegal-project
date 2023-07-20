package com.api.paralegal.utils;

public class Constants {

    public class SuccesResponse {
        public static final String CREATED = "Creado exitosamente";
        public static final String UPDATED = "Actualizado exitosamente";
        public static final String DELETED = "Eliminado exitosamente";
        public static final String GET_ALL = "Todos los resultados fueron obtenidos exitosamente";
        public static final String FIND_BY_ID = "Resultado de la busqueda obtenido exitosamente";
    }

    public class ErrorResponse {
        public static final String ELEMENT_NOT_FOUND = "No se encontraron resultados";
    }

    public class Endpoints {
        //ENTITIES
        public static final String AUDIENCIAS="/audiencias";
        public static final String EXPEDIENTES = "/expedientes";
        public static final String CLIENTES = "/clientes";
        public static final String JUZGADOS = "/juzgados";
        public static final String RECORDATORIOS = "/recordatorios";

        //SWAGGER
        public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
        public static final String SWAGGER_UI = "/swagger-ui/**";
        public static final String SWAGGER_DOCS = "/v3/api-docs";
        public static final String SWAGGER_RESOURCES = "/swagger-resources/**";

        //CRUD
        public static final String GET_BY_ID = "/search/{id}";
        public static final String CREATE = "/create";
        public static final String UPDATE = "/update/{id}";
        public static final String DELETE = "/delete/{id}";
        public static final String LIST_ALL = "/listAll";
    }

}

