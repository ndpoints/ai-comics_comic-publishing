package com.ai.comics.service;

import com.ai.comics.entity.PublicationEntity;
import com.ai.comics.model.Publication;
import com.ai.comics.model.PublicationResponse;
import com.ai.comics.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<PublicationResponse> getAllPublications() throws Exception {
        return publicationRepository.findAll().stream()
                .map(this::convertEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void createPublication(Publication publication) throws Exception {
        PublicationEntity entity = convertModelToEntity(publication);
        publicationRepository.save(entity);
    }

    @Override
    public void deletePublicationById(Integer publicationId) throws Exception {
        publicationRepository.deleteById(publicationId);
    }

    @Override
    public PublicationResponse getPublicationById(Integer publicationId) throws Exception {
        PublicationEntity entity = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new Exception("Publication not found"));
        return convertEntityToModel(entity);
    }

    @Override
    public void updatePublicationById(Integer publicationId, Publication publication) throws Exception {
        PublicationEntity entity = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new Exception("Publication not found"));
        entity.setComicId(publication.getComicId());
        entity.setPublishedAt(publication.getPublishedAt());
        entity.setStatus(publication.getStatus());
        entity.setPlatform(publication.getPlatform());
        publicationRepository.save(entity);
    }

    private PublicationResponse convertEntityToModel(PublicationEntity entity) {
        PublicationResponse response = new PublicationResponse();
        response.setPublicationId(entity.getPublicationId());
        response.setComicId(entity.getComicId());
        response.setPublishedAt(entity.getPublishedAt());
        response.setStatus(entity.getStatus());
        response.setPlatform(entity.getPlatform());
        return response;
    }

    private PublicationEntity convertModelToEntity(Publication publication) {
        PublicationEntity entity = new PublicationEntity();
        entity.setPublicationId(publication.getPublicationId());
        entity.setComicId(publication.getComicId());
        entity.setPublishedAt(publication.getPublishedAt());
        entity.setStatus(publication.getStatus());
        entity.setPlatform(publication.getPlatform());
        return entity;
    }
}