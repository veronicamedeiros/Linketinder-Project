package org.linketinder.DBDAO

import groovy.sql.Sql

class DAO {

    private String url
    private String user
    private String password
    private String driver

    DAO(String _url, String _user, String _password, String _driver) {
        setUrl(_url)
        setUser(_user)
        setPassword(_password)
        setDriver(_driver)
    }


    void connectDataBase() {

        try {
            this.url = _url
            this.user = _user
            this.password = _password
            this.driver = _driver
            Sql.newInstance url, user, password, driver
        }
        catch (Exception e){

            e.printStackTrace()
        }
    }


    String getUrl() {
        return url
    }

    void setUrl(String url) {
        this.url = url
    }

    String getUser() {
        return user
    }

    void setUser(String user) {
        this.user = user
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getDriver() {
        return driver
    }

    void setDriver(String driver) {
        this.driver = driver
    }
}
