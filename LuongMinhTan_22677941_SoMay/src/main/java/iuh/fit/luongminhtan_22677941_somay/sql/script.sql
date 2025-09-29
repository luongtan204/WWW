-- Tao database
CREATE DATABASE IF NOT EXISTS QLBenhNhan;
USE QLBenhNhan;

-- Xoa bang neu ton tai
DROP TABLE IF EXISTS BENHNHAN;
DROP TABLE IF EXISTS KHOA;

-- Bang KHOA
CREATE TABLE KHOA (
                      MAKHOA INT AUTO_INCREMENT PRIMARY KEY,
                      TENKHOA VARCHAR(100) NOT NULL,
                      TRUONGKHOA VARCHAR(100),
                      MOTA TEXT
);

-- Bang BENHNHAN
CREATE TABLE BENHNHAN (
                          MABN INT AUTO_INCREMENT PRIMARY KEY,
                          HOTEN VARCHAR(100) NOT NULL,
                          NGAYNHAPVIEN DATE,
                          CHUANDOAN VARCHAR(200),
                          MAKHOA INT,
                          CONSTRAINT fk_khoa FOREIGN KEY (MAKHOA) REFERENCES KHOA(MAKHOA)
                              ON DELETE SET NULL
                              ON UPDATE CASCADE
);

-- Them du lieu mau vao KHOA
INSERT INTO KHOA (TENKHOA, TRUONGKHOA, MOTA) VALUES
                                                 ('Noi tong hop', 'BS. Nguyen Van A', 'Dieu tri cac benh noi khoa tong quat'),
                                                 ('Ngoai chan thuong', 'BS. Tran Thi B', 'Phau thuat, chan thuong chinh hinh'),
                                                 ('Nhi', 'BS. Le Van C', 'Dieu tri cho tre em'),
                                                 ('San', 'BS. Pham Thi D', 'Kham va dieu tri san phu khoa');

-- Them du lieu mau vao BENHNHAN
INSERT INTO BENHNHAN (HOTEN, NGAYNHAPVIEN, CHUANDOAN, MAKHOA) VALUES
                                                                  ('Nguyen Van Nam', '2025-01-10', 'Viem phoi', 1),
                                                                  ('Tran Thi Hoa', '2025-02-15', 'Gay tay', 2),
                                                                  ('Pham Van Minh', '2025-03-01', 'Sot xuat huyet', 3),
                                                                  ('Le Thi Hong', '2025-03-05', 'Thai ky 12 tuan', 4),
                                                                  ('Do Van An', '2025-03-12', 'Dau da day', 1),
                                                                  ('Nguyen Thi Lan', '2025-03-18', 'Viem ruot thua', 2);
benhnhan