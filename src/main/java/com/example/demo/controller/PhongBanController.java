package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.AddChucVuForm;
import com.example.demo.dto.request.AddPhongBanForm;
import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.ChucVu;
import com.example.demo.model.PhongBan;
import com.example.demo.service.PhongBanService;
import com.example.demo.service.ChucVuService;


@RestController
@CrossOrigin(origins = "*")
public class PhongBanController {
    @Autowired
    PhongBanService phongBanService;
    @Autowired
    ChucVuService ChucVuService;

   
    @PostMapping("/addPB")
    public ResponseEntity<?> register(@Valid @RequestBody AddPhongBanForm addPhongBanForm) {
        if (phongBanService.existsBytenPB(addPhongBanForm.getTenPB())) {
            return new ResponseEntity<>(new ResponMessage("Phòng ban đã tồn tại"), HttpStatus.OK);
        }
        PhongBan phongBan = new PhongBan(addPhongBanForm.getTenPB(),addPhongBanForm.getMoTaPB());
        phongBanService.save(phongBan);
        return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
    }


    @DeleteMapping("/deletePB/{id}")
    public  ResponseEntity<String> deleteNhanVien(@PathVariable("id") int id) {
        if(phongBanService.deleteById(id)==true)
            {
                return new ResponseEntity<String>("Phong Ban deleted successfully!.", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Delete failed", HttpStatus.OK);

    }
    

    @PutMapping("/updatePB/{id}")
	public ResponseEntity<PhongBan> updateEmployee(@PathVariable("id") long id ,@RequestBody AddPhongBanForm addPhongBanForm){
        PhongBan phongBan = new PhongBan(addPhongBanForm.getTenPB(),addPhongBanForm.getMoTaPB());
        return new ResponseEntity<PhongBan>(phongBanService.updatePhongBan(phongBan, id), HttpStatus.OK);
	}

    @GetMapping("/PBs") // List Phong ban
    public ResponseEntity<List<PhongBan>> listRegisteredPhongBan() {
        List<PhongBan> nhanVien = phongBanService.findAllPhongBan();
        return ResponseEntity.ok(nhanVien);
    }


//Chức Vu



@PostMapping("/addCV")
public ResponseEntity<?> register(@Valid @RequestBody AddChucVuForm addChucVuForm) {
    if (ChucVuService.existsBytenCV(addChucVuForm.getTenCV())) {
        return new ResponseEntity<>(new ResponMessage("Phòng ban đã tồn tại"), HttpStatus.OK);
    }
    ChucVu chucVu = new ChucVu(addChucVuForm.getTenCV(),addChucVuForm.getMoTaCV());
    ChucVuService.save(chucVu);
    return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
}


@DeleteMapping("/deleteCV/{id}")
public  ResponseEntity<String> deleteChucVu(@PathVariable("id") int id) {
    if(ChucVuService.deleteById(id)==true)
        {
            return new ResponseEntity<String>("Phong Ban deleted successfully!.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Delete failed", HttpStatus.OK);

}


@PutMapping("/updateCV/{id}")
public ResponseEntity<ChucVu> updateEmployee(@PathVariable("id") long id ,@RequestBody AddChucVuForm addChucVuForm){
    ChucVu ChucVu = new ChucVu(addChucVuForm.getTenCV(),addChucVuForm.getMoTaCV());
    return new ResponseEntity<ChucVu>(ChucVuService.updateChucVu(ChucVu, id), HttpStatus.OK);
}

@GetMapping("/CVs") // List Phong ban
public ResponseEntity<List<ChucVu>> listRegisteredChucVu() {
    List<ChucVu> nhanVien = ChucVuService.findAllChucVu();
    return ResponseEntity.ok(nhanVien);
}
}
