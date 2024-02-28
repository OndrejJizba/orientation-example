package com.gfa.orientationexampleexam.services;

import com.gfa.orientationexampleexam.models.Link;

import java.util.List;

public interface LinkService {
    List<Link> getAllLinks();
    Link saveLink(Link link);
}
