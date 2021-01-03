package org.example;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;

public interface User32 extends StdCallLibrary {
    User32 INSTANCE = (User32) Native.load("User32",User32.class);
    int GetWindowRect(WinDef.HWND hwnd, WinDef.RECT rect);
    boolean SetCursorPos(int x,int y);
    void mouse_event(int dwFlags,int dx,int dy,int dwData,int dwExtraInfo);
    void keybd_event(int bVk, int bScan, int dwFlags, int dwExtralnfo);
}
