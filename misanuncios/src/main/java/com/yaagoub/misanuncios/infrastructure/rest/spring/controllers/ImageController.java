package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaagoub.misanuncios.application.service.ImageService;
import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ImageDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.ImageDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/v3/content")
public class ImageController {
    private  final ImageService imageService;
    private final CycleAvoidingMappingContext context=new CycleAvoidingMappingContext();
    private final ImageDtoMapper imageDtoMapper;

    @PostMapping("images/new")
    public ResponseEntity<Object> saveImage(@RequestBody ImageDto imageDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object>  data = new HashMap<>();
        if(this.getAuthentication() instanceof User user){
            Image image = imageDtoMapper.toDomain(imageDto,context);
            return ResponseEntity.ok().body(imageDtoMapper.toDto(imageService.save(image),context));
        }else {
            data.put("description","Authentication required");
            data.put("status",false);
            return ResponseEntity.ok().body(mapper.writeValueAsString(data));
        }



    }
    @GetMapping("images/delete/{id}")
    public ResponseEntity<Object> deleteImage(@PathVariable String id){
        Image image = imageService.findById(Long.parseLong(id));
        if(image!=null){
            imageService.delete(image);
        }
        return ResponseEntity.ok().body("done");
    }
    @GetMapping("images/product/{idProduct}")
    public ResponseEntity<Object> imagesByProduct(@PathVariable long idProduct){
        var response =imageService.getImagesByProduct(idProduct).stream().map(
                image -> imageDtoMapper.toDto(image,context)
        ).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }
//    @GetMapping("images/show/{id}")
//    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
//        Image image = imageService.findById(id);
//
//        if (image == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        byte[] imageBytes = Base64.getDecoder().decode(image.getPath());
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(getImageType(image.getPath()));
//
//        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
//    }

//    private MediaType getImageType(String base64Image) {
//        if (base64Image.startsWith("/9j/")) {
//            return MediaType.IMAGE_JPEG;
//        } else if (base64Image.startsWith("iVBORw0KGgo")) {
//            return MediaType.IMAGE_PNG;
//        } else if (base64Image.startsWith("R0lGODdh") || base64Image.startsWith("R0lGODlh")) {
//            return MediaType.IMAGE_GIF;
//        } else {
//            return MediaType.APPLICATION_OCTET_STREAM;
//        }
//    }


    Object getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal();
    }
}
