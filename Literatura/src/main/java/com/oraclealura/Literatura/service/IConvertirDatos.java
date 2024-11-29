package com.oraclealura.Literatura.service;

public interface IConvertirDatos {
    <T> T obtenerDatos(String json, Class<T> clase);

}
