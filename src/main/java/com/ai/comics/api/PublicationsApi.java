package com.ai.comics.api;

import com.ai.comics.model.Publication;
import com.ai.comics.model.PublicationResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-13T13:07:44.183044Z[Etc/UTC]", comments = "Generator version: 7.10.0")
@Validated
@Tag(name = "publications", description = "the publications API")
public interface PublicationsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /publications : Get all publications
     *
     * @return A list of publications (status code 200)
     */
    @Operation(
        operationId = "publicationsGet",
        summary = "Get all publications",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of publications", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PublicationResponse.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/publications",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<PublicationResponse>> publicationsGet(
        
    ) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"publication_id\" : 0, \"comic_id\" : 6, \"published_at\" : \"2000-01-23T04:56:07.000+00:00\", \"platform\" : \"platform\", \"status\" : \"status\" }, { \"publication_id\" : 0, \"comic_id\" : 6, \"published_at\" : \"2000-01-23T04:56:07.000+00:00\", \"platform\" : \"platform\", \"status\" : \"status\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /publications : Create a new publication
     *
     * @param publication  (required)
     * @return Publication created successfully (status code 201)
     */
    @Operation(
        operationId = "publicationsPost",
        summary = "Create a new publication",
        responses = {
            @ApiResponse(responseCode = "201", description = "Publication created successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/publications",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> publicationsPost(
        @Parameter(name = "Publication", description = "", required = true) @Valid @RequestBody Publication publication
    ) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /publications/{publicationId} : Delete a publication by ID
     *
     * @param publicationId  (required)
     * @return Publication deleted successfully (status code 204)
     */
    @Operation(
        operationId = "publicationsPublicationIdDelete",
        summary = "Delete a publication by ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Publication deleted successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/publications/{publicationId}"
    )
    
    default ResponseEntity<Void> publicationsPublicationIdDelete(
        @Parameter(name = "publicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("publicationId") Integer publicationId
    ) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /publications/{publicationId} : Get a publication by ID
     *
     * @param publicationId  (required)
     * @return A single publication (status code 200)
     */
    @Operation(
        operationId = "publicationsPublicationIdGet",
        summary = "Get a publication by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "A single publication", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/publications/{publicationId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<PublicationResponse> publicationsPublicationIdGet(
        @Parameter(name = "publicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("publicationId") Integer publicationId
    ) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"publication_id\" : 0, \"comic_id\" : 6, \"published_at\" : \"2000-01-23T04:56:07.000+00:00\", \"platform\" : \"platform\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /publications/{publicationId} : Update a publication by ID
     *
     * @param publicationId  (required)
     * @param publication  (required)
     * @return Publication updated successfully (status code 200)
     */
    @Operation(
        operationId = "publicationsPublicationIdPut",
        summary = "Update a publication by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Publication updated successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/publications/{publicationId}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> publicationsPublicationIdPut(
        @Parameter(name = "publicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("publicationId") Integer publicationId,
        @Parameter(name = "Publication", description = "", required = true) @Valid @RequestBody Publication publication
    ) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
