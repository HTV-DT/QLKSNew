package com.example.demo.controller;

import com.example.demo.dto.request.AddNhanVienForm;
import com.example.demo.dto.request.SignInForm;
import com.example.demo.dto.request.SignUpForm;
import com.example.demo.dto.response.JwtResponse;
import com.example.demo.dto.response.ResponMessage;
import com.example.demo.helper.BarCode;
import com.example.demo.helper.ExcelExporter;
import com.example.demo.helper.Helper;
import com.example.demo.model.CTBangCong;
import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;
import com.example.demo.model.Role;
import com.example.demo.model.RoleName;
import com.example.demo.model.User;
import com.example.demo.security.jwt.JwtProvider;
import com.example.demo.security.userprincal.UserPrinciple;
import com.example.demo.service.CTBangCongService;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.PhongBanService;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    PhongBanService phongBanService;
    @Autowired
    CTBangCongService bangCongService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponMessage("The username existed"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponMessage("The email existed"), HttpStatus.OK);
        }
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(),
                passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "ADMIN":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(
                            () -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "PM":
                    Role pmRole = roleService.findByName(RoleName.PM)
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER)
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getAuthorities()));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listRegisteredUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/addNhanVien")
    public ResponseEntity<?> register(@Valid @RequestBody AddNhanVienForm addNhanVienForm) {
        if (nhanVienService.existsByEmail(addNhanVienForm.getEmail())) {
            return new ResponseEntity<>(new ResponMessage("The email existed"), HttpStatus.OK);
        }
        PhongBan phongBan=phongBanService.findBymaPB(addNhanVienForm.getPhongban_id());
        NhanVien nhanVien = new NhanVien(addNhanVienForm.getTenNhanSu(), addNhanVienForm.getCCCD(),
                addNhanVienForm.getEmail(), addNhanVienForm.getNgaySinh(), addNhanVienForm.getHinhAnh(),
                addNhanVienForm.getDanToc(), addNhanVienForm.getQuocTich(), addNhanVienForm.getNgayKyHopDong(),
                addNhanVienForm.getSoTK(),addNhanVienForm.getSDT(),phongBan);
                byte[] qrCode =BarCode.getQRCodeImage(nhanVien.toString(), 200, 200);
                String s = Base64.getEncoder().encodeToString(qrCode);
                nhanVien.setQrCode(s);
                nhanVienService.save(nhanVien);
        return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteNhanVien/{id}")
    public  ResponseEntity<String> deleteNhanVien(@PathVariable("id") int id) {
        nhanVienService.deleteById(id);
        return new ResponseEntity<String>("Nhan Vien deleted successfully!.", HttpStatus.OK);
    }
    

    @PutMapping("/updateNhanVien/{id}")
	public ResponseEntity<NhanVien> updateEmployee(@PathVariable("id") long id ,@RequestBody AddNhanVienForm addNhanVienForm){
        PhongBan phongBan=phongBanService.findBymaPB(addNhanVienForm.getPhongban_id());
        NhanVien nhanVien = new NhanVien(addNhanVienForm.getTenNhanSu(), addNhanVienForm.getCCCD(),
        addNhanVienForm.getEmail(), addNhanVienForm.getNgaySinh(), addNhanVienForm.getHinhAnh(),
        addNhanVienForm.getDanToc(), addNhanVienForm.getQuocTich(), addNhanVienForm.getNgayKyHopDong(),
        addNhanVienForm.getSoTK(),addNhanVienForm.getSDT(),phongBan);
        
        return new ResponseEntity<NhanVien>(nhanVienService.updateNhanVien(nhanVien, id), HttpStatus.OK);
	}

    @GetMapping("/nhanviens") // List NhanVien
    public ResponseEntity<List<NhanVien>> listRegisteredNhanVien() {
        List<NhanVien> nhanVien = nhanVienService.findAllNhanVien();
        return ResponseEntity.ok(nhanVien);
    }

    @PostMapping("/nhanvien/upload") // upload list NhanVien file excel
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            // true
            this.nhanVienService.saveFile(file);

            return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }

    @GetMapping("export") // export excel
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<NhanVien> listNhanVien = nhanVienService.findAllNhanVien();

        ExcelExporter excelExporter = new ExcelExporter(listNhanVien);

        excelExporter.export(response);
    }

    @PostMapping("/bangcong/upload") // upload list bangcong file excel
    public ResponseEntity<?> uploadBC(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            // true
           bangCongService.saveFile(file);

            return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }

    @GetMapping("/bangCongs") // List bangcongs
    public ResponseEntity<List<CTBangCong>> listRegisteredBangCong() {
        List<CTBangCong> bangCongs = bangCongService.findAllBangCong();
        return ResponseEntity.ok(bangCongs);
    }

    
    @PostMapping("/search")
    public ResponseEntity<?> Search(@Valid @RequestBody AddNhanVienForm addNhanVienForm) {
       List<NhanVien> nhanViens= nhanVienService.search(addNhanVienForm.getTenNhanSu());
       
        return new ResponseEntity<>(nhanViens, HttpStatus.OK);
    }

    //HttpServletResponse response trả về request
    @RequestMapping(value = "qrcode", method = RequestMethod.GET)
	public void qrcode(HttpServletResponse response) throws Exception {
        List<NhanVien> nhanViens= nhanVienService.search("Vỉ HuynhHuynh");
        NhanVien nv=nhanViens.get(0);
        byte[] decodedBytes = Base64.getDecoder().decode(nv.getQrCode());
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(decodedBytes);
		outputStream.flush();
		outputStream.close();
	}
}
