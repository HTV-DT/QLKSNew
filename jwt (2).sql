-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th4 20, 2023 lúc 02:20 AM
-- Phiên bản máy phục vụ: 8.0.31
-- Phiên bản PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `jwt`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baocao`
--

DROP TABLE IF EXISTS `baocao`;
CREATE TABLE IF NOT EXISTS `baocao` (
  `MaBC` int NOT NULL,
  `Thang` date NOT NULL,
  PRIMARY KEY (`MaBC`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baocaochitiet`
--

DROP TABLE IF EXISTS `baocaochitiet`;
CREATE TABLE IF NOT EXISTS `baocaochitiet` (
  `MaBC` bigint NOT NULL,
  `MaNhanVien` bigint NOT NULL,
  `DoanhThu` double NOT NULL,
  PRIMARY KEY (`MaBC`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieudatphong`
--

DROP TABLE IF EXISTS `chitietphieudatphong`;
CREATE TABLE IF NOT EXISTS `chitietphieudatphong` (
  `MaDatPhong` bigint NOT NULL,
  `MaPhong` bigint NOT NULL,
  `SoNgayDat` int NOT NULL,
  `DonGia` double NOT NULL,
  `NgayDen` date NOT NULL,
  `NgayDi` date NOT NULL,
  PRIMARY KEY (`MaDatPhong`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
CREATE TABLE IF NOT EXISTS `chucvu` (
  `macv` bigint NOT NULL AUTO_INCREMENT,
  `mo_tacv` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tencv` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trang_thaicv` bit(1) NOT NULL,
  PRIMARY KEY (`macv`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`macv`, `mo_tacv`, `tencv`, `trang_thaicv`) VALUES
(1, 'Phòng ban chuyên mãng kỹ thuật cty', 'Lập Trinh ViênViên', b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
CREATE TABLE IF NOT EXISTS `dichvu` (
  `MaDichVu` bigint NOT NULL,
  `TenDichVu` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `DonGia` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
CREATE TABLE IF NOT EXISTS `hoa_don` (
  `ma_hoa_don` bigint NOT NULL AUTO_INCREMENT,
  `ma_dat_phong` bigint DEFAULT NULL,
  `ma_khach_hang` bigint DEFAULT NULL,
  `ma_nhan_vien` bigint DEFAULT NULL,
  `ngay_lap` datetime DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `trang_thaicv` bit(1) NOT NULL,
  PRIMARY KEY (`ma_hoa_don`),
  UNIQUE KEY `UKq0kq7f3c47rub71utf7peb90r` (`ma_dat_phong`),
  UNIQUE KEY `UK2kf9n0my0pe2xyjy3uyrgi4o2` (`ma_khach_hang`),
  UNIQUE KEY `UK9v2dbtdwmwgggvk2w6wpipl9w` (`ma_nhan_vien`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
CREATE TABLE IF NOT EXISTS `khach_hang` (
  `ma_khach_hang` bigint NOT NULL AUTO_INCREMENT,
  `cccd` int DEFAULT NULL,
  `dia_chi` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  `ngay_sinh` datetime DEFAULT NULL,
  `quoc_tich` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sdt` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ten_khach_hang` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `trang_thai` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_khach_hang`),
  UNIQUE KEY `UK16j5fmb0fl388husd7db1bq4m` (`cccd`),
  UNIQUE KEY `UKj3lhg8opnqln2wcb41cp14xn9` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaiphong`
--

DROP TABLE IF EXISTS `loaiphong`;
CREATE TABLE IF NOT EXISTS `loaiphong` (
  `MaLoaiPhong` bigint NOT NULL,
  `TenLoaiPhong` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `DonGia` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_phong`
--

DROP TABLE IF EXISTS `loai_phong`;
CREATE TABLE IF NOT EXISTS `loai_phong` (
  `ma_loai_phong` bigint NOT NULL AUTO_INCREMENT,
  `ten_loai_phong` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ma_loai_phong`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `loai_phong`
--

INSERT INTO `loai_phong` (`ma_loai_phong`, `ten_loai_phong`) VALUES
(1, 'Vip'),
(2, 'Thường'),
(3, 'Phòng Superior'),
(4, 'Phòng Deluxe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
CREATE TABLE IF NOT EXISTS `nhan_vien` (
  `manv` bigint NOT NULL AUTO_INCREMENT,
  `cccd` varchar(50) DEFAULT NULL,
  `dan_toc` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `hinh_anh` longtext,
  `ngay_ky_hop_dong` varchar(50) DEFAULT NULL,
  `ngay_sinh` varchar(100) DEFAULT NULL,
  `quoc_tich` varchar(50) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `sotk` varchar(50) DEFAULT NULL,
  `ten_nhan_su` varchar(50) DEFAULT NULL,
  `trang_thai` bit(1) DEFAULT NULL,
  `phongban_id` bigint DEFAULT NULL,
  `qr_code` longtext,
  `chucvu_id` bigint DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  PRIMARY KEY (`manv`),
  UNIQUE KEY `UK93iwlyq08smlikr2p89cnsu89` (`cccd`),
  UNIQUE KEY `UK12waxxsiniyddv2lt9ianfh8a` (`email`),
  KEY `FKs9p7jgdjuo5bal2qamyv1hmlv` (`chucvu_id`),
  KEY `FKkttyp2wpy4mg7j95w5u275qou` (`phongban_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`manv`, `cccd`, `dan_toc`, `email`, `hinh_anh`, `ngay_ky_hop_dong`, `ngay_sinh`, `quoc_tich`, `sdt`, `sotk`, `ten_nhan_su`, `trang_thai`, `phongban_id`, `qr_code`, `chucvu_id`, `gioi_tinh`) VALUES
(1, '12345671234567891', 'Kinh', 'tra@gmail.com', 'https://png.pngtree.com/background/20211216/original/pngtree-telephone-operator-financial-female-company-etiquette-photographs-with-pictures-picture-image_1521526.jpg', '6/11/2022', '9/10/2001', 'VietNam', '0123456789', '012345678', 'Nguyen Thanh tra', b'1', 8, NULL, 1, NULL),
(2, '12345671234567892', 'Kinh', 'phi@gamil.com', 'https://i.mdel.net/i/db/2023/4/1921704/1921704-800w.jpg', '6/11/2022', '9/10/2001', 'VietNam', '012345678', '012345678', 'Huynh Thanh', b'1', 8, NULL, 1, NULL),
(3, '12345671234567893', 'Kinh', 'vi@gmail.com', 'https://icdn.24h.com.vn/upload/3-2019/images/2019-08-11/Doa-tung-anh-khach-khoa-than-len-mang-nhan-vien-nha-nghi-co-the-doi-dien-an-5-nam-tu-luat-su-nguyen-trung-tiep-1565535663-868-width660height440.jpg', '6/11/2022', '9/10/2001', 'VietNam', '012987654', '012987654', 'Huynh Thanh Vi', b'1', 8, NULL, 1, NULL),
(9, '12345671234567890', 'Kinh', 'duongng@gmail.com', 'https://images.pexels.com/photos/36469/woman-person-flowers-wreaths.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', '6/11/2022', '9/10/2001', 'VietNam', '012345678', '123456789', 'Vỉ HuynhHuynh', b'1', 8, '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', 1, NULL),
(12, '12345671234567894', 'Kinh', 'nam.nguyen@base.vn', 'https://png.pngtree.com/background/20230328/original/pngtree-the-businessman-operator-traveling-agent-working-in-the-office-businessman-operator-picture-image_2179724.jpg', '6/11/2022', '9/10/2001', 'VietNam', '0912384756', '0912384756', 'Trần Viễn', b'1', 8, 'iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADTklEQVR4Xu3WPbKsKBgGYEhgC5jo1jCBLUDCTwJb0ES2hglsQRMY+szUXL117SadqSbkoWgbPl4A9amB3zv+bV/5yqt95T8tBWBHGS4K2kgFBbpHdN4GM4XTUZwPXrqE8n3Ne/V5GXFkqE+Y4tZwRxgFqFsIXw0AMuwLTH2isz1XpxQ0CuZ8/z9P0n72V7uv25O05vOZRgUPOoV/ej5ImeyihnAAhc+I1NQlRBDCBNwYYjxS3CXYr/t5ngeY1z0JpntkOtPg94PBddObkJfZnoXnavO+h0URJtPQJeM42DNRJgiYgl+7RFHt8KKt0ecxeaM7pLppUwwe8+rbbmTXIwWawToiTVvMg/Dr7zxK3df9kBt0o0Dtq48eKThR6YsaxykEM209UkNwRLDBrgfDBx27pMAFAF30Nu9x2FOPlHnjUSiBI3cIAP4z+oNU66OM2nBvN8T09asfpfBtStBmN6LBWzP9jP4kCO8J4BqKUAyITpnyapj0azDydLBHWunWhFoRllHafC66R9YyR+gdbfNEnPNP3wcpFAiGhg1QmBcFbvn2JDWpwVbHlJJ+I2r+NdsbiQwoIlqNVGsEu5z6N7Iopc3sFAAKMXU59W9kA3NwjLRYbrMBqjukEJmdmOu5x9m78ZZvjwIo0y1bCKBtjL8l+aPwM2K72hq8w0ZMr76PIvgh9z0qpRAhMvRIO44tYeOQ2pE/i/Y9UqRPwzYfis7VeyN0jxAFqNy9QTi0cL6t25PUY17oEGpeZI2yXG+zZ4my5hyHdV3mjfxdVB9lt35T8pAHmpLOt7R8kiJGQrUhgzdUH/Jysp7ldT0LpIMhr+M1XDP+UQpfc2RCn4nBnMT0M/qTSEMEJXh5rat111vzUWrSaVpDnNt+tI8nXXLaBLjDbetazrbt6BG7jERuVC5jq0TcJxEGM7RKlLkl0rWqnqUgGeeCGGhTtZvmki5vBLYXgBsWILiPBFyz91Fe881nAu1k4fO4pcujtM2m3NrCyBQ2ck2xN6ITmY1qacnoSG4vrmehvG78AAC0VBbg+qp5J8HBZc57bgfSX2/At7InJm1CMLVBXaITbG+ncRRqxAZdXgFvpK1OK9ukECJMh+sXPMof21e+8mpf+f/JX7pplVBZK7U2AAAAAElFTkSuQmCC', 1, NULL),
(13, '12345671234567895', 'Kinh', 'ceo.baseinc@gmail.com', 'https://images.pexels.com/photos/36469/woman-person-flowers-wreaths.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', '6/11/2022', '9/10/2001', 'VietNam', '1092374568', '1092374568', 'Nguyễn Thị', b'1', 8, 'iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADV0lEQVR4Xu3Wu9HsJhQAYJRAC1ICrUECLaAEUAItoERqTSSoBZSAuWuPzX/H7JLas4T6GMTrnAMovQZ+//B3+8pXfrWv/KclA4gpRgndBl2SAj0i+rbTQQyXSt9e5CGhwkvx+Om8pDAcDopBt3OJA8rhuGgPZrAGq7c4JvqOWOqsSCT7ff9cT08A5P+03/atI9X4mpaosJoO+vr+UfIs8nreHoCZGPZjBn1Zds+5nEIIzlIqmtHeiDvLtQRD9WPUcrWjdWXa03pf68Uez4FCzWhdKZ5KVn8f4Qzg4pcRyXKxS8LzciB3MHePybRHDNh2sXJAHfWAlCTl6icrzjPc996s9I3sZt3DwTZDrAKq2dE3ktbt2Q2zULGtznxEMmR2snDy5BBnWtrT7kq5n81TuBoStuda/IhkjAyErEYLXzy704iUzaM0K2aYi5Ph7Ur7YsV2AD4DERfLMdYDksn5XKJE4fV9btf06v1JAGCnEaVeQ66mREakRG2Ju6btud2+bduQ2MkDyRU72Llvpd2druQa8nW2EABSzsfZIZFg8aJYgFGsSbnNYl0pWSlJPFdAB5cUeX37JAdfnJGUz+Q8M5d6RLLS+x6yqskCYjWPCVjqbZdAceFVXe6I2PVSgF3rFidncHPabySYmstXo8OTdLja+9aX50kKuWc/XV6fvY3TrmQI4RouqhMGdGY/4rQrvOaWo6bjGlae4zaPdqW4KGuS9FJbvVvWZrGu1O13IVNkoShnSO3d6Quys5SYhUgiZK5daV/WWpxQnmvh2AxG+4iUO3iUgZwMKXumf9bAD5KX50KJCyMieRJpI6srJQL0GFEPg69RkmNEMpVUSqmfYFB92pBX709SHyjhPuqrIRw6iTaCu1K8PhSY9s0gWxMsH5G8hMfXeoEimNW6tZm8L+K5qMTrgSGc/5rAJynXdLCQ6s6gLDlqa0lXMtT79hy1PLl7r4f46v1Jprsm5T0CTCwAoKkYfakG5JJqosBi84qNSAYo8ylKjtV61jeRHhF915pcx0GZHLTNYm+EcrwEd9V36pJm0K70naxpyuLiAFDk22h8I8KdzkVxgZkV00ZJX3QkZ0Jnrq/bC6P2ZdcXACGtMT9LBaGc2+rclX9tX/nKr/aV/5/8Ad6ojnjDmBTmAAAAAElFTkSuQmCC', 1, NULL),
(14, '12345671234567896', 'Kinh', 'fsfsddfd@gmail.com', 'https://i.mdel.net/i/db/2023/4/1921704/1921704-800w.jpg', '2023-04-21', '2000-07-30', 'Việt Nam', '0123456789', '47268762874627', 'Huynh Thanh Vi', b'1', 5, 'iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADWElEQVR4Xu3WPbKkKhgGYEhwC5rI1iSBLUjCTwJbkAS2pglsARO49MzUHXtqOE16bx2Cri6eKkX4eAHUXgN/dvzbvuVbXu1b/tNSwBSXW5Gy8lT2DcgRkZGFgq1NNouZlSHZWISKRVIPJE+KxoTKTPmBFXQRjQpzl1MICKlWEsdERmIWs4uNAmjT+/f0BCD6u73PW09eiPMmBC8C6l89H6SAbcpLmYFYtF8XNyLVrFKnc4krj/g2ckQKu5Ihx4ZPeEeS6Q/6JLJ6bq2zaqa4Zv542heia0bc1QyDF8yOSHVOX7fa2H1fpQ18RIpU0up0ELPNlBxv1duVdakRq8lAHaXz65AsiuuIy1Rw8mhJr75PUush2qIlsxQguCJjctlz3udFEWetjXJACmz7BOAQd4RY9fuQbDADysOd5eX3X7X4ScQSXEuKYymTC5ENyU6ucKIZR3YrmWc5Irweky7M3gXeXobH076QVr3sDsGQlhTkOequ1FOevFXuvBQWnFmGJNhzEzNY4lRPsT9mtC9l51qrFkdYzdx6MSQrQADJDDZp/dp+B6RGMaVbofZy2gIG/+j7JJ62rXsbCqg0gD6/pyuFCrAi2lLMxSmL5y7pCwI7jm3UdArHBp6p3BcY7H2fLOMC5K2fe64vLb6SrQoAeGlFfkbfJ9l5vdyxk5R5KPKZ/n2Z2oOQDDrzy2/gmS59aROSnKHYObPLK7z6PgogZXqVrrZHO5oOOSK8tK3hPLlzy/+307kviw1lqfakMHlununfF+xXklTLippcS+hX30dZN3i5SwGKxAb1cwRdaUugdVIz03m631KsL4UYfFB+X4d0ZafPndUX2QZ+KypWbPMO71ffR5kRQlPKgJ1MG3g+ntaV6mWblMxTO9JwaDk2IC3HxZKOdfIyZWLe7js9qZdf1+VgeRZol+4x6i/knMI5VbW1krKKPla7L6VVu29LwNs/rvBzTfsCL2um2lIMaz+DdUReNcKc2cS+tgL+uXCfpN3SNsCuk84It0E/39MXmQrUJxXQU+7FW4V0pZ2zlNUDrPwyK4CvvgFpp/lG7MHNOr+l5VeCz1W62vKV6fC8BfRFRqwzUZS1yvJ/3ON70g6ZGdaQ8uQMmN/vvR35a/uWb3m1b/n/yT+Xka1iFwFtdAAAAABJRU5ErkJggg==', 1, NULL),
(15, '321332331232', 'Kinh', 'duongduong1duong1@gmail.com', 'https://upload.wikimedia.org/wikipedia/commons/5/5f/T_cursiva.gif', '6/11/2022', '9/10/2001', 'Viêt Nam', '01234567', '1234567890', 'Vỉ Huynh', b'1', NULL, 'iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADqklEQVR4Xu2XPa6kPBBFCxE4gw0geRvO2FKzARo2AFsiYxuWvIEmc4DwHAP9vh9pgq6WJhrUwZMPejZVt26VJf3ukf8v/Dx/iZbsIvbl7NE2vZTzuosrXyJPLXmm5tGWh2mKlLbFzilseVFJHsamZAcXDiOVE5FyW5ovSNPFNEZfOTsvdmrDd8SOsTykeYj0LMevCDHoha/3XbLbUrLVv6LzMRFpuvU/v8dP5j4m+ZlcOcjeJTbZi/WtHQ3ZxUhv/MOkQVBQmlo7uaAl6WCtLeeEdso57sXi6/sECrLXS5mWpkvNc0mHs4OUr/sEGtKte9VeCWcHX6xhaK9sa8gz2jlKt9pXm8alHJDPfWoVWckMhcvxfb0AfSX3Pp8TEsLX2zGV/F5tmAw1d+VHQ8b83f7R+qptqlaea1OZax8F4byUhS+WlHKJEM40OK8laWQTg/qkMhgVetzrdJ9AQQ6xg8kVXCxhWxtxTYeatGRL4XBh4i8y0/o6Un/XPhpyZN3x6bu0aVtLDJWQqMkW9172J9mOp/Mln7OkJHsXy6n1D8crNp83/lNzClKve2/OfVa7rejIvruZhlATPQZvCAbLbJLm25U1pIi5cHGpZ/bjLMM6XhrVkEqkzlUbOGzliIGIObWjIWR4v46M+dXZHig7NcmdVoQ2yys2Za/CCy+vUpBzH4ft7Xj85HLNPXlFSybGCEYJQ5OUhwmH5LFCTRBy73A+LGEnohyZqUdNBkwlNjRYHJQYYKvYjJYgujAxizkhEgw74xLGeClRQ4rzf/fixTCRSY+U4pVtBUlp9T2DpyEA0mW/L7d0TyifE6qkxPZOf6KCQx4H1nf9fEzoZntlaGJN32ZjQOMvd8ZARV6MOeyzMgLYg6AauStYRQYJ44rHo+6AfJhTxnjrQEFo11vMAkwLGwa86mWSmgznDrgdNwBqbsRWb/dXEIJnxyW9kA+3E5PXqvZSlYKgHRosuzHcEVQsP7xrTkPIz2RQDWLM0zqtUvL7OsKpszlh7V3E3XEsWllzx+Bz0mEGOL0hlmSJcPrb+VRETJoX/C8w+D+pFWouqkn+3C432ByMbaGb8W74guSEHy1mYGdeoUSuG5iGnHemmOemYpWCNTR+zbAqwiYpMjox6TDveMn950ejH5PcGw2Tdb6sz6zFdwy0JMsnMqSTnKxx5tBvSJE8QyL3Evpk77JpqQn34HpBj2iH4Y5ZO1/W1YT89I65KZDwImvHn4WiI797/pI/R34BMhFlklUbEgcAAAAASUVORK5CYII=', NULL, NULL),
(16, '321332333213', 'Kinh', 'duongduouong1@gmail.com', 'https://upload.wikimedia.org/wikipedia/commons/5/5f/T_cursiva.gif', '6/11/2022', '9/10/2001', 'Viêt Nam', '01234567', '1234567890', 'Vỉ Huynh', b'1', NULL, 'iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADrklEQVR4Xu2XTQ6kOAyFjVhkBxeIlGtklyvBBfi5AFwpu1wDKReo2rFAeJ4Tpqe7pV6US5pVR7UpPkSC/fxsiP+06PcLP9ZfoiUXkVt8ewc7BepTXmP7Ipq1ZGbbgBs7eF5Ce1N+y0UlGYzjyJtcIwpHR+072i+I7SOvfPSneye3hfwdcXtqF7IDUYfL/BVBDMbEa6KRsU+7R/dTdD4mRCC//IYfmfuYyJJTm2tkbHLM+FXtaAjyTE28BsoLudu3i3ebz1rCL38NgffTkmn3k1/h6NNRTq0hS8CDEUU7R769wy2QZNlHQfDqeWUclibCDleTsG2rJbx4PJjG5F6BF2pXubHGQEGuPh4N83oeY2Tkp4kolKodDZlQbeGgAL20L5NRfGt0ZR8F4XfMLxzcHFOw/WnnZOE3XxD4AA4rt+wwKo9w1mwrCCqY34yEU2doCqIdbKgm4+kQg6bEkgiFgrJ7dKAgQ8gbXZOB/x2DP0Ym8rW2NaSTM+YlXIMHbJdgx0c7CsI3QTIQCwRYnQ+GWmOtITvMGClCLA0vRhI+UK0SBbnmE+rDPjBmhz7WR/GbEgMF4a38GwgnFQUtgf+tRg15J94M74xn26Kj66k5FdkjDV4SDmvvE3MUC6zR0ZB0TaUyoJrOQEQou1pzCnL1yWKU2ND8k7vFq44xVVUpCJJ8dR6vDseizqNvHLCEEgMNgXAajDmMgoOV5tvTT+7yMcHauV2TnSQteAm5t+yjIVtAII8mQdSttNyAnD+q+pxczYkWhB6LnLvbwLryfhbtaAiWW+H0Bq0M7m7ns90fXWvIKp6HOQVZovkksb3TqclGbsM4JkrE9JTX03aG9cTgh5ETE/HVSQwQlaodDeGEOULO3jO0A2k7fpxPQaT6Jyo279HNbJPad42BhpTJ2hwDZBjRiMrsk54YKAjOO55iJ/CY/aRGUl1joCEbWWkUqb2hRHQ2Tz3LjSpy9WdGwSEng8E11Bw6ZHV/Dem8W4sAX9IxsIMTg9GSUWouL+jYJ+7CGFXbkZqg1PIGASbRNYp48lUHGkImv2S+hoiww0EeXzk1ogqChacWr0IAkhyZzKN4FbnI4zMO30zoPDKLQZLPPh8T+Wbqi/ONiZqI9mjHWLxKRWY4X+JbJh3MOwcsYX6ioyH4ckUFyywGJ0h5Z/Rt/ob0jKEJH9NHH5Ecfklk9GRMSDIOjmtUxkY9wZgzyVaZT+nhFKRu1ETyg6oVGSI/yDac77/MfUj+tP6S/4/8A7g0TZi/ACxBAAAAAElFTkSuQmCC', NULL, b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieudatcoc`
--

DROP TABLE IF EXISTS `phieudatcoc`;
CREATE TABLE IF NOT EXISTS `phieudatcoc` (
  `MaDatCoc` bigint NOT NULL,
  `MaKhachHang` bigint NOT NULL,
  `SoTien` double NOT NULL,
  `MaNhanVien` bigint NOT NULL,
  `MaLoaiPhong` bigint NOT NULL,
  `NgayDatCoc` date NOT NULL,
  `TrangThai` tinyint(1) NOT NULL,
  PRIMARY KEY (`MaDatCoc`),
  UNIQUE KEY `MaKhachHang` (`MaKhachHang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieudatphong`
--

DROP TABLE IF EXISTS `phieudatphong`;
CREATE TABLE IF NOT EXISTS `phieudatphong` (
  `MaDatPhong` bigint NOT NULL,
  `MaKhachHang` bigint NOT NULL,
  `SoKhach` int NOT NULL,
  `MaNhanVien` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieudichvu`
--

DROP TABLE IF EXISTS `phieudichvu`;
CREATE TABLE IF NOT EXISTS `phieudichvu` (
  `MaHoaDon` bigint NOT NULL,
  `MaDichVu` bigint NOT NULL,
  `SoLuong` int NOT NULL,
  `TongTien` double NOT NULL,
  `MaNhanVien` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong`
--

DROP TABLE IF EXISTS `phong`;
CREATE TABLE IF NOT EXISTS `phong` (
  `MaPhong` bigint NOT NULL,
  `MaLoaiPhong` bigint NOT NULL,
  `TrangThai` tinyint(1) NOT NULL,
  `GhiChu` varchar(200) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongs`
--

DROP TABLE IF EXISTS `phongs`;
CREATE TABLE IF NOT EXISTS `phongs` (
  `phong_id` bigint NOT NULL AUTO_INCREMENT,
  `ghi_chu` text COLLATE utf8mb4_general_ci,
  `phong_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image_url` longtext COLLATE utf8mb4_general_ci,
  `price` double DEFAULT NULL,
  `loaiphong_id` bigint NOT NULL,
  PRIMARY KEY (`phong_id`),
  KEY `FKewbpyg163uhqai40hkf6dlq6h` (`loaiphong_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phongs`
--

INSERT INTO `phongs` (`phong_id`, `ghi_chu`, `phong_name`, `image_url`, `price`, `loaiphong_id`) VALUES
(1, '\r\nĐỗ xe và Wi-Fi luôn miễn phí, vì vậy quý khách có thể giữ liên lạc, đến và đi tùy ý. Nằm ở vị trí trung tâm tại Xương Huân của Nha Trang, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. Hãy nhớ dành một chút thời gian để thăm thú Vinpearl Land Nha Trang cũng như Biển Nha Trang gần đó. Được xếp hạng 5 sao, chỗ nghỉ chất lượng cao này cho phép khách nghỉ sử dụng bể bơi trong nhà, mát-xa và bồn tắm nước nóng ngay trong khuôn viên.', 'Muong Thanh Luxury Khanh Hoa', 'https://pix8.agoda.net/hotelImages/6359030/-1/450c557cca55c993033d5811ed6cb41d.jpg?ca=10&ce=1&s=1024x768', 1480, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong_ban`
--

DROP TABLE IF EXISTS `phong_ban`;
CREATE TABLE IF NOT EXISTS `phong_ban` (
  `mapb` bigint NOT NULL AUTO_INCREMENT,
  `tenpb` varchar(50) DEFAULT NULL,
  `trang_thaipb` bit(1) NOT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mapb`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

--
-- Đang đổ dữ liệu cho bảng `phong_ban`
--

INSERT INTO `phong_ban` (`mapb`, `tenpb`, `trang_thaipb`, `mo_ta`) VALUES
(2, 'Tài Chính', b'1', NULL),
(5, 'Thuật', b'1', NULL),
(8, 'Kỹ Thuật', b'1', 'Phòng ban chuyên mãng kỹ thuật ctycty');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nb4h0p6txrmfc0xbrd1kglp9t` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'USER'),
(2, 'PM'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `hinh_anh` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `username`, `hinh_anh`) VALUES
(1, 'htv@gmail.com', ' thanh vi', '$2a$10$FmirVrbNCEKNhG2NAGXqBu2XrNzEGmo2i8kwPBsta2wP5ktVJpGMi', 'thanhvi1', NULL),
(2, 'ts@gmail.com', ' thai son', '$2a$10$fGUn8ez/lJOiadQ.21GvtOUyrAXL5x.9X787yeZisk76fQLE0k3b6', 'thaison', NULL),
(3, 'ntra@gmail.com', ' thanhtra', '$2a$10$hLhwjxVTAmBVOzF/f8ix/.wNU6/GhWKMgUosHuecYHU.CT4vbHReW', 'thanhtra', NULL),
(4, 'htp@gmail.com', 'thanh vi', '$2a$10$xZUpo6doNUzMM6idld1LVeA612KmBj/bAf5d5fYfhT21jPuNi7neW', 'thanhvi', 'https://i.mdel.net/i/db/2023/4/1921704/1921704-800w.jpg'),
(5, 'htva@gmail.com', 'thanh vi huynh', '$2a$10$6k6DErI57YhcR2RUhsTteOGsGsjQ8QORQBXhGHUWR1B7BC1dEqhbO', 'vi1', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

--
-- Đang đổ dữ liệu cho bảng `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 3),
(2, 1),
(3, 3),
(4, 1),
(5, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
