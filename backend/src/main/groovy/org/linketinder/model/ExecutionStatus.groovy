package org.linketinder.model

class ExecutionStatus {


    static showOperationsStatus(Exception e ){

        if(e = null){
            "Operação realizada com sucesso."
        }
        else{
            "Não foi possível realizar a operação. Erro: ${e.message}"
            e.printStackTrace()
        }
    }



}
