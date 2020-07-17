package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.ws.*;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

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

    @Inject WSClient ws;

    public CompletionStage<Result> echoService(){
        return ws.url("http://www.mocky.io/v2/53c7ec8426e0e3fd14326b0d")
                .get()
                .thenApply(response -> ok("Feed Response: "+response.getBody()));
    }

}
