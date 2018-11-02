package com.github.alexanderwe.bananaj.model.filemanager;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Nullable;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.utils.DateConverter;

/**
 * Class for representing a file manager folder. Created by alexanderweiss on
 * 22.01.16.
 */
public class FileManagerFolder extends MailchimpObject {

    private static final Logger        LOGGER = LoggerFactory.getLogger(FileManagerFolder.class);

    /** The folder id. */
    private int                        folderId;

    /** The name. */
    private String                     name;

    /** The file count. */
    private int                        file_count;

    /** The created at. */
    private LocalDateTime              createdAt;

    /** The created by. */
    private String                     createdBy;

    /** The files. */
    private ArrayList<FileManagerFile> files;

    /** The json data. */
    private JSONObject                 jsonData;

    /** The connection. */
    private MailChimpConnection        connection;

    /**
     * Instantiates a new file manager folder.
     *
     * @param id         the id
     * @param name       the name
     * @param file_count the file count
     * @param createdAt  the created at
     * @param createdBy  the created by
     * @param jsonData   the json data
     * @param connection the connection
     */
    public FileManagerFolder(int id, String name, int file_count, LocalDateTime createdAt, String createdBy,
            JSONObject jsonData, MailChimpConnection connection) {
        super(String.valueOf(id), jsonData); // set string representation of folder id
        this.folderId   = id;        // set integer representation of folder id
        this.name       = name;
        this.file_count = file_count;
        this.createdAt  = createdAt;
        this.createdBy  = createdBy;
        this.connection = connection;
    }

    /**
     * Instantiates a new file manager folder.
     *
     * @param connection            the connection
     * @param jsonFileManagerFolder the json file manager folder
     */
    public FileManagerFolder(MailChimpConnection connection, JSONObject jsonFileManagerFolder) {
        super(String.valueOf(jsonFileManagerFolder.getInt("id")), jsonFileManagerFolder); // set string representation
                                                                                          // of folder id
        this.folderId   = jsonFileManagerFolder.getInt("id");                         // set integer representation of
                                                                                      // folder id
        this.name       = jsonFileManagerFolder.getString("name");
        this.file_count = jsonFileManagerFolder.getInt("file_count");
        this.createdAt  = DateConverter.getInstance()
                .createDateFromISO8601(jsonFileManagerFolder.getString("created_at"));
        this.createdBy  = jsonFileManagerFolder.getString("created_by");
        this.connection = connection;
    }

    /**
     * Change name.
     *
     * @param name the name
     * @throws Exception the exception
     */
    public void changeName(String name) throws Exception {
        JSONObject changedFolder = new JSONObject();
        changedFolder.put("name", name);
        this.connection.do_Patch(new URL(this.getConnection().getFilemanagerfolderendpoint() + "/" + this.getId()),
                changedFolder.toString(), this.getConnection().getApikey());

    }

    /**
     * Delete folder.
     *
     * @throws Exception the exception
     */
    public void deleteFolder() throws Exception {
        getConnection().do_Delete(new URL(getConnection().getFilemanagerfolderendpoint() + "/" + getId()),
                getConnection().getApikey());
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the file count.
     *
     * @return the file count
     */
    public int getFile_count() {
        return file_count;
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets the created by.
     *
     * @return the created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Gets the files.
     *
     * @return the files
     */
    public ArrayList<FileManagerFile> getFiles() {
        if (files == null) { // defer loading files list untill requested.
            try {
                setFiles();
            } catch (Exception e) {
                LOGGER.error("Could not obtain the list of files", e);
            }
        }
        return files;
    }

    /**
     * Sets the files.
     *
     * @throws Exception the exception
     */
    private void setFiles() throws Exception {
        ArrayList<FileManagerFile> files = new ArrayList<FileManagerFile>();
        if (file_count > 0) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

            int                   offset = 0;
            int                   count  = 100;
            List<FileManagerFile> filelist;

            do {
                filelist  = connection.getFileManager().getFileManagerFiles(count, offset);
                offset   += count;
                for (FileManagerFile file : filelist) {
                    if (file.getFolder_id() == folderId) {
                        files.add(file);
                    }
                }
            } while (filelist.size() == 100 && files.size() < file_count);
        }
        this.files = files;
    }

    /**
     * Gets the file.
     *
     * @param id the id
     * @return the file
     */
    @Nullable
    public FileManagerFile getFile(int id) {
        for (FileManagerFile file : files) {
            if (Integer.parseInt(file.getId()) == id) {
                return file;
            }
        }
        return null;
    }

    /**
     * Gets the folder id.
     *
     * @return the folder id
     */
    public int getFolderId() {
        return folderId;
    }

    /**
     * Gets the json data.
     *
     * @return the json data
     */
    @Nullable
    public JSONObject getJsonData() {
        return jsonData;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public MailChimpConnection getConnection() {
        return connection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Folder-name: " + this.getName() + "Folder-Id: " + this.getId() + " File-count: " + this.getFile_count()
                + " Created at: " + this.getCreatedAt() + System.lineSeparator() + " Files: " + this.getFiles();
    }
}
