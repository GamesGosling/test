package com.xtkj.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClientUtils {


	private static final String CONF_FILENAME = Thread.currentThread().getContextClassLoader()
			.getResource("fastdfs_client.conf").getPath();

	private static TrackerClient trackerClient;

	// �����ļ�
	static {
		try {
			ClientGlobal.init(CONF_FILENAME);
			TrackerGroup trackerGroup = ClientGlobal.g_tracker_group;
			trackerClient = new TrackerClient(trackerGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <B>�������ƣ�</B>�ϴ�����<BR>
	 * <B>��Ҫ˵����</B><BR>
	 * 
	 * @param file
	 *            �ļ�
	 * @param path
	 *            ·��
	 * @return �ϴ��ɹ�����id��ʧ�ܷ���null
	 */
	public static String upload(File file, String path) {
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient1 storageClient1 = null;
		FileInputStream fis = null;
		try {
			NameValuePair[] meta_list = null; // new NameValuePair[0];
			fis = new FileInputStream(file);
			byte[] file_buff = null;
			if (fis != null) {
				int len = fis.available();
				file_buff = new byte[len];
				fis.read(file_buff);
			}

			trackerServer = trackerClient.getConnection();
			if (trackerServer == null) {
				System.out.println("Tracker��NULL");
			}
			storageServer = trackerClient.getStoreStorage(trackerServer);
			storageClient1 = new StorageClient1(trackerServer, storageServer);
			String fileid = storageClient1.upload_file1(file_buff, getFileExt(path), meta_list);

			return fileid;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (storageServer != null) {
				try {
					storageServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			storageClient1 = null;
		}
	}

	/**
	 * <B>�������ƣ�</B>�ϴ�����<BR>
	 * <B>��Ҫ˵����</B><BR>
	 * 
	 * @param data
	 *            ����
	 * @param path
	 *            ·��
	 * @return �ϴ��ɹ�����id��ʧ�ܷ���null
	 */
	public static String upload(byte[] data, String extName) {
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient1 storageClient1 = null;
		try {
			NameValuePair[] meta_list = null; // new NameValuePair[0];

			trackerServer = trackerClient.getConnection();
			if (trackerServer == null) {
				System.out.println("getConnection return null");
			}
			storageServer = trackerClient.getStoreStorage(trackerServer);
			storageClient1 = new StorageClient1(trackerServer, storageServer);
			String fileid = storageClient1.upload_file1(data, extName, meta_list);
			return fileid;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (storageServer != null) {
				try {
					storageServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			storageClient1 = null;
		}
	}

	/**
	 * <B>�������ƣ�</B>���ط���<BR>
	 * <B>��Ҫ˵����</B>ͨ���ļ�id��������<BR>
	 * 
	 * @param fileId
	 *            �ļ�id
	 * @return ����InputStream
	 */
	public static InputStream download(String groupName, String fileId) {
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient1 storageClient1 = null;
		try {
			trackerServer = trackerClient.getConnection();
			if (trackerServer == null) {
				System.out.println("getConnection return null");
			}
			storageServer = trackerClient.getStoreStorage(trackerServer, groupName);
			storageClient1 = new StorageClient1(trackerServer, storageServer);
			byte[] bytes = storageClient1.download_file1(fileId);
			InputStream inputStream = new ByteArrayInputStream(bytes);
			return inputStream;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (storageServer != null) {
				try {
					storageServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			storageClient1 = null;
		}
	}

	/**
	 * <B>�������ƣ�</B>ɾ������<BR>
	 * <B>��Ҫ˵����</B>����id��ɾ��һ���ļ�<BR>
	 * 
	 * @param fileId
	 *            �ļ�id
	 * @return ɾ���ɹ�����0����0�����ʧ�ܣ����ش������
	 */
	public static int delete(String groupName, String fileId) {
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient1 storageClient1 = null;
		try {
			trackerServer = trackerClient.getConnection();
			if (trackerServer == null) {
				System.out.println("getConnection return null");
			}
			storageServer = trackerClient.getStoreStorage(trackerServer, groupName);
			storageClient1 = new StorageClient1(trackerServer, storageServer);
			int result = storageClient1.delete_file1(fileId);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			if (storageServer != null) {
				try {
					storageServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			storageClient1 = null;
		}
	}

	/**
	 * <B>�������ƣ�</B><BR>
	 * <B>��Ҫ˵����</B><BR>
	 * 
	 * @param oldFileId
	 *            ���ļ�id
	 * @param file
	 *            ���ļ�
	 * @param path
	 *            ���ļ�·��
	 * @return �ϴ��ɹ�����id��ʧ�ܷ���null
	 */
	public static String modify(String oldGroupName, String oldFileId, File file, String path) {
		String fileid = null;
		try {
			// ���ϴ�
			fileid = upload(file, path);
			if (fileid == null) {
				return null;
			}
			// ��ɾ��
			int delResult = delete(oldGroupName, oldFileId);
			if (delResult != 0) {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return fileid;
	}

	/**
	 * <B>�������ƣ�</B>��ȡ�ļ���׺��<BR>
	 * <B>��Ҫ˵����</B>��ȡ�ļ���׺��<BR>
	 * 
	 * @param fileName
	 * @return �磺"jpg"��"txt"��"zip" ��
	 */
	private static String getFileExt(String fileName) {
		if (StringUtils.isBlank(fileName) || !fileName.contains(".")) {
			return "";
		} else {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}
	}

}
