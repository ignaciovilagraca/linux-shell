package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {
    @Test
    public void testQuit() throws IOException {
        String[] expectedResults = {
                ""
        };
        runTest(expectedResults, "quit");
    }

    @Test
    public void testUnrecognizedCommand() throws IOException {
        String[] expectedResults = {
                "Unrecognized command\n"
        };
        runTest(expectedResults, "sarasa");
    }

    @Test
    public void testCreateDirectory() {
        String[] expectedResults = {
                "/testFolder\n",
        };
        runTest(expectedResults, "mkdir testFolder","ls");
    }

    @Test
    public void testCreateFile() {
        String[] expectedResults = {
                "file.txt\n"
        };
        runTest(expectedResults, "touch file.txt", "ls");
    }

    @Test
    public void testListContents() {
        String[] expectedResults = {
                "/bin\n",
                "project.iml\n"
        };
        runTest(expectedResults, "mkdir bin", "touch project.iml", "ls");
    }

    @Test
    public void testChangeDirectory() {
        String[] expectedResults = {
                "test.bin\n"
        };
        runTest(expectedResults, "mkdir bin", "cd bin", "touch test.bin", "ls");
    }

    @Test
    public void testCreateFileWithNameTooLong() {
        String[] expectedResults = {
                "File name cannot have more than 100 characters\n"
        };
        runTest(expectedResults, "touch aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "ls");
    }

    @Test
    public void testCreateFolderWithNameTooLong() {
        String[] expectedResults = {
                "Directory name cannot have more than 100 characters\n"
        };
        runTest(expectedResults, "mkdir aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "ls");
    }

    @Test
    public void testCurrentDirectoryWithMultipleLevels() {
        String[] expectedResults = {
                "/root/usr/bin\n"
        };
        runTest(expectedResults, "mkdir usr", "cd usr", "mkdir bin", "cd bin", "pwd", "quit");
    }
}