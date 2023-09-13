package com.example.servlets;

import com.example.converter.CarConverter;
import com.example.dto.CarDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServletTest {
  private CarServlet servlet;
  private HttpServletRequest request;
  private HttpServletResponse response;
  private ByteArrayOutputStream outputStream;

  @BeforeEach
  public void setUp() {
    servlet = new CarServlet();
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);

    outputStream = new ByteArrayOutputStream();

    try {
      // Mock ServletOutputStream
      when(response.getOutputStream()).thenReturn(new ServletOutputStream() {
        @Override
        public boolean isReady() {
          return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }

        @Override
        public void write(int b) throws IOException {
          outputStream.write(b);
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}