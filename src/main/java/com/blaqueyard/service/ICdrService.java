package com.blaqueyard.service;

import com.blaqueyard.model.Cdr;

import java.io.IOException;
import java.util.ArrayList;

public interface ICdrService {
    public ArrayList<Cdr> findAll() throws IOException;
}
