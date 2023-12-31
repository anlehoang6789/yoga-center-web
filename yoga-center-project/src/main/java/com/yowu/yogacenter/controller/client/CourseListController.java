/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.yowu.yogacenter.controller.client;

import com.yowu.yogacenter.model.Course;
import com.yowu.yogacenter.repository.CategoryRepository;
import com.yowu.yogacenter.repository.CourseRepository;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class CourseListController extends HttpServlet {
    
    private final String COURSE_LIST_PAGE = "Client/courseList.jsp";
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryRepository categoryRepo = new CategoryRepository();
        CourseRepository cr = new CourseRepository();
        List<Course> list = cr.getActive();
        request.setAttribute("courseList", list);
        request.setAttribute("categoryList", categoryRepo.getAllActive());
        request.setAttribute("minPrice", cr.getMinCoursePrice());
        request.setAttribute("maxPrice", cr.getMaxCoursePrice());
        int itemPerPage = 4;
        int numpage = (int) Math.ceil(list.size() / (double) itemPerPage);
        request.setAttribute("numpage", numpage);
        request.setAttribute("itemPerPage", itemPerPage);
        request.getRequestDispatcher(COURSE_LIST_PAGE).forward(request, response);
    }  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
