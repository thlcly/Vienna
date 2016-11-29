package com.vienna.controllers;

/**
 * @author tonyhui
 * @since 16/11/28
 */
public interface ViennaRoutes {

    String ROOT = "/";
    String INDEX = "/index";

    /**
     * User Module
     */
    String USER_ROOT = "/user";
    String USER_LOGIN = "/login";
    String USER_SAVEORUPDATE = "/saveOrUpdate";
    String USER_DELETE = "/delete/{userId}";
}
