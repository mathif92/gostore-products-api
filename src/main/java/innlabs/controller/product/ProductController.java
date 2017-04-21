package innlabs.controller.product;

import gostore.product.ProductDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mathias on 14/04/17.
 */
@Api
@RestController
@RequestMapping("productsa/")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.GET, value = "{productId}")
    @ResponseBody
    @ApiOperation(value = "products", nickname = "products", response = String.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 200, message = "Product returned successfully"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseEntity<String> getProduct(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
