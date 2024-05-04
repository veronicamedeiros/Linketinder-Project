package org.linketinder.DBDAO.DAOinterfaces

interface Ientities {

    void delete(Integer id, Integer chosenOption)

    void update(Integer id, Integer chosenOption, String updatedInformation)

    List<Map> list()

    void register()
}