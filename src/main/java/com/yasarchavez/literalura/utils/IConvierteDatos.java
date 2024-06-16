package com.yasarchavez.literalura.utils;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
