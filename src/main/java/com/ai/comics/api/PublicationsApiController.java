package com.ai.comics.api;

import com.ai.comics.model.Publication;
import com.ai.comics.model.PublicationResponse;
import com.ai.comics.service.PublicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Validated
@RestController
@Tag(name = "publications", description = "the publications API")
public class PublicationsApiController implements PublicationsApi {

    private final PublicationService publicationService;

    @Autowired
    public PublicationsApiController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @Override
    @Operation(
        operationId = "publicationsGet",
        summary = "Get all publications",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of publications", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationResponse.class))
            })
        }
    )
    @GetMapping(value = "/publications", produces = { "application/json" })
    public ResponseEntity<List<PublicationResponse>> publicationsGet() throws Exception {
        List<PublicationResponse> publications = publicationService.getAllPublications();
        return new ResponseEntity<>(publications, HttpStatus.OK);
    }

    @Override
    @Operation(
        operationId = "publicationsPost",
        summary = "Create a new publication",
        responses = {
            @ApiResponse(responseCode = "201", description = "Publication created successfully")
        }
    )
    @PostMapping(value = "/publications", consumes = { "application/json" })
    public ResponseEntity<Void> publicationsPost(
        @Parameter(name = "Publication", description = "", required = true) @Valid @RequestBody Publication publication
    ) throws Exception {
        publicationService.createPublication(publication);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @Operation(
        operationId = "publicationsPublicationIdDelete",
        summary = "Delete a publication by ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Publication deleted successfully")
        }
    )
    @DeleteMapping(value = "/publications/{publicationId}")
    public ResponseEntity<Void> publicationsPublicationIdDelete(
        @Parameter(name = "publicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("publicationId") Integer publicationId
    ) throws Exception {
        publicationService.deletePublicationById(publicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @Operation(
        operationId = "publicationsPublicationIdGet",
        summary = "Get a publication by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "A single publication", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PublicationResponse.class))
            })
        }
    )
    @GetMapping(value = "/publications/{publicationId}", produces = { "application/json" })
    public ResponseEntity<PublicationResponse> publicationsPublicationIdGet(
        @Parameter(name = "publicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("publicationId") Integer publicationId
    ) throws Exception {
        PublicationResponse publication = publicationService.getPublicationById(publicationId);
        return new ResponseEntity<>(publication, HttpStatus.OK);
    }

    @Override
    @Operation(
        operationId = "publicationsPublicationIdPut",
        summary = "Update a publication by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Publication updated successfully")
        }
    )
    @PutMapping(value = "/publications/{publicationId}", consumes = { "application/json" })
    public ResponseEntity<Void> publicationsPublicationIdPut(
        @Parameter(name = "publicationId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("publicationId") Integer publicationId,
        @Parameter(name = "Publication", description = "", required = true) @Valid @RequestBody Publication publication
    ) throws Exception {
        publicationService.updatePublicationById(publicationId, publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}