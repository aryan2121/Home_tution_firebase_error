package com.amanaryan.hometutions

class SaveTutorData (
                     val tutor_name: String,
                     val Image:String,
                     val email: String,
                     val qualification:String,
                     val aadhar:String,
                     val mobile:String,
                     val taught_class:String,
                     val subjects:String,
                     val specialization_subject:String,
                     val fee:String,
                     val location:String,
                     val present_address:String,
                     val place_tution:String,
                     val description:String,
                     val experience:String
)
{

    constructor() : this("", "","","","","","","","","","",
        "","","","")



}