package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by user on 14.07.2016.
 */
@MyController(urlPath = "/jobs")
public class JobController {

    @MyRequestMethod(urlPath = "/all")
    public String getAllJobs() {

        return "allJobs";
    }

    @MyRequestMethod(urlPath = "/one")
    public String getOneEJob() {

        return "oneRandomJob";
    }
}
