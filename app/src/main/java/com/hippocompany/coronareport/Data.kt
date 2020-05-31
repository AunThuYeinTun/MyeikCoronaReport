package com.hippocompany.coronareport

class DataInfo {


    var tittle: String? = ""
    var date: Int? = null
    var bodytext: String? = ""

    constructor(tittle: String?, bodytext: String?, date: Int?) {
        this.tittle = tittle
        this.bodytext = bodytext
        this.date = date
    }

}