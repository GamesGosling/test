package com.xtkj.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtils {
	// FTP服务器地址
	public String hostname;
	// FTP服务器端口号默认为21
	public Integer port;
	// FTP登录账号
	public String username;
	// FTP登录密码
	public String password;

	public FTPClient ftpClient = null;

	/**
	 * 初始化FTP服务器
	 */
	public void initFtpClient() {
		//加载配置文件
		InputStream inpt = FtpUtils.class.getClassLoader().getResourceAsStream("com/xtkj/utils/ftp.properties");
		Properties pp = new Properties();

		ftpClient = new FTPClient();
		ftpClient.setControlEncoding("utf-8");

		try {
			pp.load(inpt);
			hostname = pp.getProperty("Hostname");
			port=Integer.valueOf(pp.getProperty("Port"));
			username = pp.getProperty("Url");
			password = pp.getProperty("Password");
			
			
			System.out.println("connecting...ftp服务器:" + this.hostname + ":" + this.port);
			// 连接FTP服务器
			ftpClient.connect(hostname, port); 
			// 登录FTP服务器
			ftpClient.login(username, password); 
			// 是否成功登录服务器
			int replyCode = ftpClient.getReplyCode(); 

			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("connect failed...ftp服务器:" + this.hostname + ":" + this.port);
			}
			System.out.println("connect successfu...ftp服务器:" + this.hostname + ":" + this.port);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * 上传文件
	 * 
	 * @param pathname       FTP服务保存地址
	 * @param fileName       上传到FTP的文件名
	 * @param originfilename 待上传文件的名称（绝对地址） *
	 * @return
	 */
	@SuppressWarnings({ "static-access", "unused" })
	public boolean uploadFile(String pathname, String fileName, String originfilename) {

		boolean flag = false;
		InputStream inputStream = null;
		try {
			System.out.println("开始上传文件");
			inputStream = new FileInputStream(new File(originfilename));
			initFtpClient();
			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
			CreateDirecroty(pathname);
			ftpClient.makeDirectory(pathname);
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.storeFile(fileName, inputStream);
			inputStream.close();
			ftpClient.logout();
			flag = true;
			System.out.println("上传文件成功");
		} catch (Exception e) {
			System.out.println("上传文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	/**
	 * -上传文件
	 * @param pathname    FTP服务保存地址
	 * @param fileName    上传到FTP的文件名
	 * @param inputStream 输入文件流
	 * @return
	 */
	@SuppressWarnings("static-access")
	public boolean uploadFile(String pathname, String fileName, InputStream inputStream) {
		@SuppressWarnings("unused")
		boolean flag = false;
		try {
			System.out.println("开始上传文件");

			initFtpClient();

			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);

			CreateDirecroty(pathname);

			ftpClient.makeDirectory(pathname);
			ftpClient.changeWorkingDirectory(pathname);

			ftpClient.storeFile(fileName, inputStream);
			inputStream.close();
			ftpClient.logout();
			flag = true;
			System.out.println("上传文件成功");
		} catch (Exception e) {
			System.out.println("上传文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	/** 
	 * -改变目录路径
	 * @param directory
	 * @return
	 */
	public boolean changeWorkingDirectory(String directory) {
		boolean flag = true;
		try {
			flag = ftpClient.changeWorkingDirectory(directory);
			if (flag) {
				System.out.println("进入文件夹" + directory + " 成功！");

			} else {
				System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return flag;
	}

	
	/**
	 * -创建多层目录文件，如果有FTP服务器已存在该文件，则不创建，如果无，则创建
	 * @param remote
	 * @return
	 * @throws IOException
	 */
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote + "/";

		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			String path = "";
			String paths = "";
			while (true) {
				String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
				path = path + "/" + subDirectory;
				if (!existFile(path)) {
					if (makeDirectory(subDirectory)) {
						changeWorkingDirectory(subDirectory);
					} else {
						System.out.println("创建目录[" + subDirectory + "]失败");
						changeWorkingDirectory(subDirectory);
					}
				} else {
					changeWorkingDirectory(subDirectory);
				}

				paths = paths + "/" + subDirectory;
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}

	
	/**
	 *  -判断FTP服务器文件是否存在
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public boolean existFile(String path) throws IOException {
		boolean flag = false;
		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
		if (ftpFileArr.length > 0) {
			flag = true;
		}
		return flag;
	}

	
	/**
	 * -创建目录
	 * @param dir
	 * @return
	 */
	public boolean makeDirectory(String dir) {
		boolean flag = true;
		try {
			flag = ftpClient.makeDirectory(dir);
			if (flag) {
				System.out.println("创建文件夹" + dir + " 成功！");

			} else {
				System.out.println("创建文件夹" + dir + " 失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	/**
	 *-下载文件 
	 * @param pathname  FTP服务器文件目录 
	 * @param filename  文件名称 
	 * @param localpath 下载后的文件路径 
	 * @return
	 */
	public boolean downloadFile(String pathname, String filename, String localpath) {
		boolean flag = false;
		OutputStream os = null;
		try {
			//初始化ftp
			initFtpClient();

			// 切换FTP目录
			ftpClient.changeWorkingDirectory(pathname);

			FTPFile[] ftpFiles = ftpClient.listFiles();
			for (FTPFile file : ftpFiles) {
				if (filename.equalsIgnoreCase(file.getName())) {
					File localFile = new File(localpath + "/" + file.getName());
					os = new FileOutputStream(localFile);
					ftpClient.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			ftpClient.logout();
			flag = true;
			System.out.println("下载文件成功");
		} catch (Exception e) {
			System.out.println("下载文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}


	
	/**
	 * -删除文件 
	 * @param pathname FTP服务器保存目录 
	 * @param filename 要删除的文件名称 
	 * @return
	 */
	public boolean deleteFile(String pathname, String filename) {
		boolean flag = false;
		try {
			System.out.println("开始删除文件");
			initFtpClient();
			// 切换FTP目录
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.dele(filename);
			ftpClient.logout();
			flag = true;
			System.out.println("删除文件成功");
		} catch (Exception e) {
			System.out.println("删除文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}





	/**
	 * -测试FTP工具类
	 * @param args
	 */
	public static void main(String[] args) {
		FtpUtils ftp = new FtpUtils();
		ftp.uploadFile("/", UUID.randomUUID()+"_"+"abc.png", "d://abc.png");
		// ftp.uploadFile("ftpFile/data", "123.docx", "E://123.docx");
		//ftp.downloadFile("/images/upload/", "abc.png", "e://");
		//ftp.deleteFile("ftpFile/data", "123.docx");
		System.out.println("ok");
	}
}



