package com.example.service;

import com.example.repo.Library;
import com.example.repo.RepoLibrary;

public class ServiceLibraryImpl implements ServiceLibrary {

    RepoLibrary repoLibrary = new Library();

    @Override
    public String translate(String word) {
        return repoLibrary.translate(word);
    }
}
