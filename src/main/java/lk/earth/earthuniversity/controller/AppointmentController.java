package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.AppointmentDao;
import lk.earth.earthuniversity.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentDao appointmentDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Appointment> getAll(@RequestParam HashMap <String,String> params) {

        String appointmenttypeid = params.get("appointmenttypeid");
        String appointmentstatusid = params.get("appointmentstatusid");
        String clinictypeid = params.get("clinictypeid");
        String patientid = params.get("patientid");
        String number = params.get("number");
        String date = params.get("date");
        String employeeid = params.get("employeeid");


        List<Appointment> appointments = this.appointmentDao.findAll();
        if(params.isEmpty()) return appointments;

        Stream<Appointment> appointmentStream = appointments.stream();


        if(appointmenttypeid!=null) appointmentStream = appointmentStream.filter(a -> a.getAppointmenttype().getId() ==Integer.parseInt(appointmenttypeid));
        if(appointmentstatusid!=null) appointmentStream = appointmentStream.filter(a -> a.getAppointmentstatus().getId() ==Integer.parseInt(appointmentstatusid));
        if(clinictypeid !=null) appointmentStream = appointmentStream.filter(a -> a.getClinic().getId() ==Integer.parseInt(clinictypeid));
        if(patientid!=null) appointmentStream = appointmentStream.filter(a -> a.getPatient().getId() ==Integer.parseInt(patientid));
        if(number!=null) appointmentStream = appointmentStream.filter(a -> a.getNumber().equals(number));
        if(employeeid!=null) appointmentStream = appointmentStream.filter(a -> a.getEmployee().getId() ==Integer.parseInt(employeeid));
        if(date!=null) appointmentStream = appointmentStream.filter(a -> a.getDate().toString().equals(date));


        return  appointmentStream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment get(@PathVariable Integer id) {
        Appointment appointment = this.appointmentDao.findByMyId(id);
        return appointment;
    }
    @GetMapping(path ="/patientid/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getbypatientid(@PathVariable Integer id) {
        List<Appointment> appointments = this.appointmentDao.findByPatientId(id);
        return appointments;
    }

    @GetMapping(path ="/countbyclinic/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Long getcount(@PathVariable Integer id) {
         return  this.appointmentDao.countByClinic(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Appointment appointment){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        String number =  appointment.getNumber();

        if(appointmentDao.findByNumber(number)!=null)
            errors = errors+"<br> Existing Number";

        if(errors == ""){
            appointment.setDate(new Timestamp( new Date().getTime()));
            appointmentDao.save(appointment);
        }else{
            errors = "Server Validation Errors : <br> "+errors;
        }

        response.put("id",String.valueOf(appointment.getId()));
        response.put("url","/appointments/"+appointment.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Appointment appointment){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Appointment appoint =  appointmentDao.findByNumber(appointment.getNumber());

        if(appoint!=null && appointment.getId()!=appoint.getId())
            errors = errors+"<br> Existing Appointment";

        if(errors=="") appointmentDao.save(appointment);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(appointment.getId()));
        responce.put("url","/appointments/"+appointment.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Appointment appointment = appointmentDao.findByMyId(id);
        if(appointment==null)
            errors = errors+"<br> Appointment Does Not Exist";

        if(errors.isEmpty()) appointmentDao.delete(appointment);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/appointments/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


