package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Link;
import com.gfa.orientationexampleexam.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImp  implements LinkService{

    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImp(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }
}
