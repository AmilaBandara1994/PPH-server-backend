package lk.earth.earthuniversity.report;

import lk.earth.earthuniversity.report.dao.ClinicCountByClinictypeDao;
import lk.earth.earthuniversity.report.dao.CountByDesignaitonDao;
import lk.earth.earthuniversity.report.dao.DiagnosisCountByTreatmentplanDao;
import lk.earth.earthuniversity.report.entity.ClinicCountByClinictype;
import lk.earth.earthuniversity.report.entity.CountByDesignation;
import lk.earth.earthuniversity.report.entity.DiagnosisCountByTreatementplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/reports")
public class ReportController {
    @Autowired
    private CountByDesignaitonDao countbydesignaitondao;

    @Autowired
    private ClinicCountByClinictypeDao clinicCountByClinictypeDao;
    @Autowired
    private DiagnosisCountByTreatmentplanDao diagnosisCountByTreatmentplanDao;

    @GetMapping(path ="/countbydesignation",produces = "application/json")
    public List<CountByDesignation> get() {

        List<CountByDesignation> designations = this.countbydesignaitondao.countByDesignation();
        long totalCount = 0;

        for (CountByDesignation countByDesignation : designations) {
            totalCount += countByDesignation.getCount();
        }

        for (CountByDesignation countByDesignation : designations) {
            long count = countByDesignation.getCount();
            double percentage = (double) count / totalCount * 100;
            percentage = Math.round(percentage * 100.0) / 100.0;
            countByDesignation.setPercentage(percentage);
        }

        return designations;
    }

    @GetMapping(path ="/cliniccountbyclinictype",produces = "application/json")
    public List<ClinicCountByClinictype> getClinic() {
        List<ClinicCountByClinictype> clinicCountByClinictypes = this.clinicCountByClinictypeDao.clinicCountByClinicType();
        return clinicCountByClinictypes;
    }

    @GetMapping(path ="/diagnosiscountbytreatmentplan",produces = "application/json")
    public List<DiagnosisCountByTreatementplan> getCoundbydiagnosis() {
        List<DiagnosisCountByTreatementplan> diatplans = this.diagnosisCountByTreatmentplanDao.diagcountbytret();
        long totalCount = 0;

        for (DiagnosisCountByTreatementplan countByTreatments : diatplans) {
            totalCount += countByTreatments.getCount();
        }

        for (DiagnosisCountByTreatementplan countBytplan : diatplans) {
            long count = countBytplan.getCount();
            double percentage = (double) count / totalCount * 100;
            percentage = Math.round(percentage * 100.0) / 100.0;
            countBytplan.setPercentage(percentage);
        }

        return diatplans;
    }
}


