package com.ai.comics.service;

import com.ai.comics.model.Publication;
import com.ai.comics.model.PublicationResponse;
import java.util.List;

/**
 * Service interface for managing publications.
 */
public interface PublicationService {

    /**
     * Get all publications.
     *
     * @return A list of publications.
     * @throws Exception if an error occurs while fetching the publications.
     */
    List<PublicationResponse> getAllPublications() throws Exception;

    /**
     * Create a new publication.
     *
     * @param publication The publication to create.
     * @throws Exception if an error occurs while creating the publication.
     */
    void createPublication(Publication publication) throws Exception;

    /**
     * Delete a publication by ID.
     *
     * @param publicationId The ID of the publication to delete.
     * @throws Exception if an error occurs while deleting the publication.
     */
    void deletePublicationById(Integer publicationId) throws Exception;

    /**
     * Get a publication by ID.
     *
     * @param publicationId The ID of the publication to retrieve.
     * @return The publication with the specified ID.
     * @throws Exception if an error occurs while fetching the publication.
     */
    PublicationResponse getPublicationById(Integer publicationId) throws Exception;

    /**
     * Update a publication by ID.
     *
     * @param publicationId The ID of the publication to update.
     * @param publication The publication data to update.
     * @throws Exception if an error occurs while updating the publication.
     */
    void updatePublicationById(Integer publicationId, Publication publication) throws Exception;
}