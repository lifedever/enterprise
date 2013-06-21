package com.app.permission.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 处理文件的工具类
 * 
 * @项目 archiveManager2.1
 * @作者 gefangshuai
 * @Email gefangshuai@163.com
 * @QQ 99220202
 * @创建时间 2012-9-11 下午2:24:08
 */
public final class FileUtils {
	/**
	 * 删除文件
	 * 
	 * @param file
	 */
	public static void deleteFile(File file) {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					deleteFile(files[i]);
				}
			}
			file.delete();
		} else {
			System.out.println("所删除的文件不存在！" + '\n');
		}
	}

	/**
	 * 向文件中写入内容
	 * 
	 * @param file
	 *            目标文件
	 * @param content
	 *            写入的内容
	 * @param end
	 *            true 在文件末尾追加; false 在文件开头追加
	 * @param append
	 *            是否追加（追加还是重写）
	 */
	public static void writeFile(File file, String content, boolean start, boolean append) {
		FileWriter writer = null;
		try {
			if (!file.exists())
				file.createNewFile();
			if (start && append) {
				StringBuffer sb = new StringBuffer(content);
				sb.append(getString(file));
				writer = new FileWriter(file, false);
				writer.write(sb.toString());
			} else {
				writer = new FileWriter(file, append);
				writer.write(content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 得到文件中的所有内容
	 * 
	 * @param file
	 * @return
	 */
	public static String getString(File file) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 向文件中写入内容(以追加的方式,在文件末尾追加)
	 * 
	 * @param file
	 *            目标文件
	 * @param content
	 *            写入的内容
	 */
	public static void writeFile(File file, String content) {
		FileWriter writer = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			writer = new FileWriter(file, true);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 统一转换为标准文件格式，即以"/"作为分隔
	 * 
	 * @param strPath
	 * @return
	 */
	public static String convertPath(String strPath) {
		return strPath.replaceAll("\\", "/");
	}

	/**
	 * 根据目录名,文件名生成完整路径.
	 * 
	 * @param strPath
	 * @param strFileName
	 * @return
	 */
	public static String assembleFilePath(String strPath, String strFileName) {
		String path = convertPath(strPath);
		if (path.charAt(path.length() - 1) != '/')
			path = (new StringBuilder()).append(path).append("/").toString();
		return (new StringBuilder()).append(path).append(strFileName).toString().replaceAll("//", "/");
	}

	/**
	 * 获得输入流
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream openInputStream(File file) throws IOException {
		if (file.exists()) {
			if (file.isDirectory())
				throw new IOException((new StringBuilder()).append("File '").append(file).append("' exists but is a directory").toString());
			if (!file.canRead())
				throw new IOException((new StringBuilder()).append("File '").append(file).append("' cannot be read").toString());
			else
				return new FileInputStream(file);
		} else {
			throw new FileNotFoundException((new StringBuilder()).append("File '").append(file).append("' does not exist").toString());
		}
	}

	/**
	 * 关闭输入流
	 * 
	 * @param input
	 */
	public static void closeInputStream(InputStream input) {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioe) {
		}
	}

	/**
	 * 获得输出流
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static FileOutputStream openOutputStream(File file) throws IOException {
		if (file.exists()) {
			if (file.isDirectory())
				throw new IOException((new StringBuilder()).append("File '").append(file).append("' exists but is a directory").toString());
			if (!file.canWrite())
				throw new IOException((new StringBuilder()).append("File '").append(file).append("' cannot be written to").toString());
		} else {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists() && !parent.mkdirs())
				throw new IOException((new StringBuilder()).append("File '").append(file).append("' could not be created").toString());
		}
		return new FileOutputStream(file);
	}

	/**
	 * 关闭输出流
	 * 
	 * @param output
	 */
	public static void closeOutputStream(OutputStream output) {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioe) {
		}
	}

	/**
	 * 将byte数组写入OutputStream
	 * 
	 * @param data
	 * @param output
	 * @throws IOException
	 */
	public static void write(byte data[], OutputStream output) throws IOException {
		if (data != null)
			output.write(data);
	}

	/**
	 * 将byte数组写入文件
	 * 
	 * @param data
	 * @param file
	 * @throws IOException
	 */
	public static void write(byte data[], File file) throws IOException {
		OutputStream out = null;
		out = openOutputStream(file);
		write(data, out);
		closeOutputStream(out);
	}

	/**
	 * 将String按指定编码格式写入OutputStream
	 * 
	 * @param data
	 * @param output
	 * @param encoding
	 * @throws IOException
	 */
	public static void write(String data, OutputStream output, String encoding) throws IOException {
		if (data != null)
			if (encoding == null)
				write(data, output);
			else
				output.write(data.getBytes(encoding));
	}

	/**
	 * 将String按指定编码格式写入文件
	 * 
	 * @param data
	 * @param file
	 * @param encoding
	 * @throws IOException
	 */
	public static void write(String data, File file, String encoding) throws IOException {
		OutputStream out = null;
		out = openOutputStream(file);
		write(data, out, encoding);
		closeOutputStream(out);
	}

	/**
	 * 将String写入OutputStream
	 * 
	 * @param data
	 * @param output
	 * @throws IOException
	 */
	public static void write(String data, OutputStream output) throws IOException {
		if (data != null)
			output.write(data.getBytes());
	}

	/**
	 * 将String写入指定文件
	 * 
	 * @param data
	 * @param file
	 * @throws IOException
	 */
	public static void write(String data, File file) throws IOException {
		write(data, file, null);
	}

	/**
	 * 将InputStream中的内容写入OuputStream中，并返回实际写入的字节数
	 * 
	 * @param input
	 * @param output
	 * @return
	 * @throws IOException
	 */
	public static long write(InputStream input, OutputStream output) throws IOException {
		byte buffer[] = new byte[4096];
		long count = 0L;
		for (int n = 0; -1 != (n = input.read(buffer));) {
			output.write(buffer, 0, n);
			count += n;
		}
		closeInputStream(input);
		closeOutputStream(output);
		return count;
	}

	/**
	 * 将文件中的内容写入OutputSteam中，并返回实际写入的字节数
	 * 
	 * @param input
	 * @param output
	 * @return
	 * @throws IOException
	 */
	public static long write(File input, OutputStream output) throws IOException {
		InputStream in = null;
		long l;
		in = openInputStream(input);
		l = write(in, output);
		closeInputStream(in);
		return l;
	}

	/**
	 * 将InputStream中的内容写入文件中，并返回实际写入的字节数
	 * 
	 * @param input
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static long write(InputStream input, File file) throws IOException {
		OutputStream out = null;
		long l;
		out = openOutputStream(file);
		l = write(input, out);
		closeOutputStream(out);
		return l;
	}

	/**
	 * 读取InputStream中的内容，返回byte数组
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static byte[] readToByteArray(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		write(input, output);
		return output.toByteArray();
	}

	/**
	 * 读取文件中的内容，返回byte数组
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] readToByteArray(File file) throws IOException {
		InputStream in = null;
		byte abyte0[];
		in = openInputStream(file);
		abyte0 = readToByteArray(in);
		closeInputStream(in);
		return abyte0;
	}

	/**
	 * 得到目录以及其子目录下的所有文件
	 * 
	 * @param directory
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Collection listFiles(File directory) {
		Collection files = new ArrayList();
		innerListFiles(files, directory);
		return files;
	}

	@SuppressWarnings("unchecked")
	private static void innerListFiles(@SuppressWarnings("rawtypes") Collection files, File directory) {
		File found[] = directory.listFiles();
		if (found != null) {
			for (int i = 0; i < found.length; i++)
				if (found[i].isDirectory())
					innerListFiles(files, found[i]);
				else
					files.add(found[i]);

		}
	}

	/**
	 * 删除目录以及该目录下的子目录和文件
	 * 
	 * @param directory
	 * @throws IOException
	 */
	public static void deleteDirectory(File directory) throws IOException {
		if (directory == null || !directory.exists())
			return;
		cleanDirectory(directory);
		if (!directory.delete()) {
			String message = (new StringBuilder()).append("Unable to delete directory ").append(directory).append(".").toString();
			throw new IOException(message);
		} else {
			return;
		}
	}

	/**
	 * 清除目录下的子目录和文件
	 * 
	 * @param directory
	 * @throws IOException
	 */
	public static void cleanDirectory(File directory) throws IOException {
		if (directory == null || !directory.exists() || !directory.isDirectory())
			return;
		File files[] = directory.listFiles();
		if (files == null)
			throw new IOException((new StringBuilder()).append("Failed to list contents of ").append(directory).toString());
		IOException exception = null;
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			try {
				forceDelete(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}

		if (null != exception)
			throw exception;
		else
			return;
	}

	/**
	 * 删除文件或目录。如果该目录下有文件或子目录，将一并删除
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void forceDelete(File file) throws IOException {
		if (file == null || !file.exists())
			return;
		if (file.isDirectory())
			deleteDirectory(file);
		else if (!file.delete()) {
			String message = (new StringBuilder()).append("Unable to delete file: ").append(file).toString();
			throw new IOException(message);
		}
	}

	/**
	 * 
	 * @param request
	 * @param param
	 *            表单参数
	 * @param desPath
	 *            目标路径
	 * @return
	 * @throws IOException
	 */
	public static String upload(HttpServletRequest request, String param, String desPath) throws IOException {
		String webRoot = System.getProperty("project.root");
		String absPath = "";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile(param);
		String fileName = file.getOriginalFilename();
		if (fileName != null && !"".equals(fileName)) {
			String type = fileName.substring(fileName.lastIndexOf("."));
			absPath = desPath + System.currentTimeMillis() + type;
			String dir = webRoot + absPath;
			File tempDir = new File(webRoot+desPath);
			if(!tempDir.exists()){
				tempDir.mkdirs();
			}
			FileUtils.write(file.getInputStream(), new FileOutputStream(new File(dir)));
		}
		return absPath;
	}
}
