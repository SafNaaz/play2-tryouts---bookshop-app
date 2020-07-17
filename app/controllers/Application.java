package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

public class Application extends Controller {

    /**
     * Process the home page
     * @return
     */
    public Result index(){
        return ok(views.html.bookshop.render());
    }

    /**
     * Get the details of a book by id
     * @param id
     * @return
     */
    public Result getBook(String id){
        return ok(views.html.bookshop.render());
    }

    @Inject
    FormFactory formFactory;

    /**
     * Accept a form post and save the comment
     * Shows the usage of dynamic form to retrieve data form html form posts
     * @param request
     * @return
     */
    public Result saveComment(Http.Request request){
        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        String comment = requestData.get("comment");
        return ok(views.html.savecomment.render());
    }

    public Result searchByTitle(String title){
        //Query db and get the book details or get from cache
        return ok(views.html.searcheresults.render());
    }
}
