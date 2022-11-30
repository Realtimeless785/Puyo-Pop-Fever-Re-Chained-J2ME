# Puyo Pop Fever Re:Chained (Java ME / J2ME)
![Puyo Pop Fever Re:Chained (English) Logo](https://user-images.githubusercontent.com/117650736/200515284-f211b9f1-b663-485d-8ee9-482bc131e9a5.png)

Other logos: [Puyo Pop Fever Re:Chained LITE](https://user-images.githubusercontent.com/117650736/204701467-0ec12a64-3c5c-4c0a-99f1-dbbe2a4da070.png) | 
[ぷよぷよフィーバーRe:れんさ (Japanese)](https://user-images.githubusercontent.com/117650736/204701425-354a7380-f844-4c3e-8bc6-b8fe8205b8fc.png)


**Puyo Pop Fever Re:Chained** is a modified version of the Puyo Puyo Fever DX (Chinese ForceGen Version) mobile game with many features, major improvements, and implementations. This mod will give you a *Puyo Puyo Fever 2*-like experience with the original Puyo Puyo Fever storylines.

This mod includes 2 versions, the **FULL** version and the low-end or stripped down version called the **LITE** version. The Full version bundled with 2 variants with the audio type, WAV and AMR. The AMR variant supports for most devices, but it has lower-quality SFX, while the WAV variant supports for some devices with higher-quality SFX (11025 Hz) and lower latency (Depends on the phone's CPU).

## Features and Improvements
![PuyoFever_ReChained_Ver_2 00_Final_Screenshots](https://user-images.githubusercontent.com/117650736/201877391-5364ce52-541b-4980-b00f-3efdc0d78e52.png)

**The FULL version includes many features:**
* **NEW** Town Map / Stage Select System,
* **NEW** Menu / In-Game Graphics,
* **NEW** Sound Effects and English/Japanese Voices (Changeable in settings),

* **Customizable** In-Game Background Themes (Available in **Pink** (Default), **Blue**, **Orange**, and **Original Fever**),

![PuyoFever_ReChained_Ver_2 00_Final_InGameBgThemes](https://user-images.githubusercontent.com/117650736/201873162-7fc3dc1b-4f33-49b5-868a-306aaa8f471f.png)
 
* **Customizable** Puyo Skins (Available in **Gummy**, **Aqua** (Default), **Retro**, **Fever**, and **Classic**),

![puyopreview_gummy](https://user-images.githubusercontent.com/117650736/201870118-31456182-e8b6-46b3-942b-ac5c0ca63c52.png) ![puyopreview_aqua](https://user-images.githubusercontent.com/117650736/201870282-2ef3943b-5938-4122-a331-352e152569f2.png) ![puyopreview_retro](https://user-images.githubusercontent.com/117650736/201870341-aa8fd942-23a2-4cc3-88c4-8777785a3a8a.png) ![puyopreview_fever](https://user-images.githubusercontent.com/117650736/201870372-633a6ffe-89ab-49af-bb4e-630f4ccf4980.png) ![puyopreview_classic](https://user-images.githubusercontent.com/117650736/201870397-217be90a-4d82-4fb4-8441-4ea942e5fc90.png) 

* Supports for **multiple resolutions** and **Auto-Adjust** screen resolution feature (240x320, 352x416, 400x240, 640x360, 800x352, and more!),

![image](https://user-images.githubusercontent.com/117650736/201683796-ecf609fd-a3cd-4d65-81f8-08f800d848b2.png)

* **QWERTY** keyboard support, and
* **Major** bug fixes.

However, the FULL version only works with higher-end J2ME-enabled phones with 64KB of maximum heap size (bytecode length) limit (e.g. Nokia Series 40 v6, Nokia/SE Symbian, Sony Ericsson, Samsung, LG) and most J2ME emulators (e.g J2ME Loader / JL-Mod, KEmulator Lite 0.9.3 / 0.9.8 / 1.0.3 / nnmod). This version does NOT compatible with lower-end Samsung, LG, Nokia Series 40 v3/v4/v5, and other phones with 32KB of maximum heap size (bytecode length) limit.

![PuyoFever_ReChained_LITE_Ver_1 50_240x320_Screenshots](https://user-images.githubusercontent.com/117650736/201879385-7613fc36-5c18-46c9-ac9a-bd23361e1a7c.png)

**The LITE version lacks some features:**
* No Town Map / Stage Select System,
* No Sound Effects and Voices,
* Simplified Menu,
* Only one Puyo skin available is Aqua, and
* Only one in-game background theme available is Pink.

This version supports most lower-end Samsung, LG, Nokia Series 40 v3/v4/v5, and other phones with 32KB of maximum heap size (bytecode length) limit. 

## In-Game Controls
* **Phone Keypad:**
    * Move Puyo Left (←) = Left D-Pad / 4
    * Move Puyo Right (→) = Right D-Pad / 6
    * Rotate Puyo Left (↑) = Up D-Pad / 2
    * Rotate Puyo Right (Select) = OK / 5
    * Drop Puyo Faster (↓) = Down / 8
    * Left Softkey = LSK
    * Right Softkey = RSK
* **QWERTY Keypad:**
    * Move Puyo Left (←) = A
    * Move Puyo Right (→) = D
    * Rotate Puyo Left (↑) = W / ,
    * Rotate Puyo Right (Select) = Enter
    * Drop Puyo Faster (↓) = S
    * Left Softkey = Shift
    * Right Softkey = Backspace

## Supported Screen Resolutions
* **Puyo Pop Fever Re:Chained**
    * 240x320 (N73, N82, N95, N96, K800i, W910i, W995, etc.)
    * 240x400 (GD580)
    * 240x432 (Aino U10i)
    * 352x416 (N80, N90, E70)
    * 400x240 (Samsung Impression)
    * 640x360* (N97, N97 mini, C6-00, E7-00, Vivaz Pro U5i)
    * 640x480* (E6-00)
    * 800x352* (E90)
    * 800x480*
    * 480x800*
    * 480x854*
* **Puyo Pop Fever Re:Chained LITE**
    * 176x208 (3230, 6600, 6630, 6680, 7610, N70, N91, etc.)
    * 176x220 (W302, W700i, W800i, W810i, K700i, K750i, etc.)
    * 240x320 (2700c, 5310 XM, 6275i, 6280, 6300, 6303i etc.)
    * 240x400 (GD580)
    * 240x432 (Aino U10i)
    * 320x240 (Nokia C3-00, Nokia X2-01, Nokia X5-01)
    * 352x416 (N80, N90, E70)
    * 400x240 (Samsung Impression)

(*) Automatically changes the softkey buttons layout

## Compatibility Issues
![image](https://user-images.githubusercontent.com/117650736/201681843-d287845a-cbce-423d-a1cc-60348379d2f7.png)

* If you experience a problem while loading sound effects (e.g. Out of Memory error), you can press both **Left and Right D-Pad** or **4 and 6** key repeatedly at the *SEGA / SONIC TEAM* splash screen until the red "**[!] SFX Disabled**" message will appear on the splash screen. This will disable the SFX functionallity and greatly reduces loading times and memory usage.

(This feature is present for the **FULL** version only, starting from Ver. 2.00 (Final Release) and later).

* Touchscreen support is *currently* not supported yet.

## Source Code Release
The source code for both of the Puyo Pop Fever Re:Chained and Puyo Pop Fever Re:Chained LITE has been released and the source codes are usable for now.

Both of these source codes included with Boilerplate J2ME project build script made by Nokia64.

You can get the [source code](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/tree/main/Source%20Codes) here.

Feel free to implement some new features or mod the game by yourself! :)

## Release Changelogs & Download
*Latest version:*

* 11/30/2022: **Ver. 2.01** - English ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_en_US_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_en_US_Release_AMR.jar)) | Portuguese ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_pt_BR_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_pt_BR_Release_AMR.jar)) | Bahasa Indonesia ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_id_ID_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_id_ID_Release_AMR.jar)) | Chinese ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_zh_CN_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_zh_CN_Release_AMR.jar))
    * Added other languages: Portuguese, Indonesian, and Chinese. The Japanese language will be added later in this version.
    * Fixed Auto-Adjust screen resolution feature to make it automatically rescale in every seconds.
    * Added support for motorola phones.
    * Minor graphical improvements.
    * Bug fixes.
* 11/30/2022: **Ver. 1.51 (LITE)** - [176x220](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.51_176.jar) | [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.51_240.jar)
    * Fixed Auto-Adjust screen resolution feature to make it automatically rescale in every seconds (Except for the 176x version).
    * Added support for motorola phones.
    * Minor graphical improvements.
    * Bug fixes.

*Old versions:*

* 11/14/2022: Ver. 2.00 (Final Release) - [WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.00_Final_WAV.jar) | [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.00_Final_AMR.jar)
    * New Character Arts from *Puyo Puyo Fever 2*!
    * New Title Screen Music from *Puyo Puyo Fever 2*!
    * New "Classic" Puyo Skin!
    * Added "Enable Sounds" prompt message on boot.
    * Added difficulty and vibration settings.
    * Customizable In-Game Background Themes (Available in Pink, Blue, Orange, and Original Fever).
    * The Full Version now supports multiple resolutions (352x416 / 400x240 / 640x360 / 800x352 / etc.) and it will automatically adjust the screen resolution when the screen wipe transition starts (Auto-Adjust Screen Resolution).
    * Major bug fixes.
* 11/14/2022: Ver. 1.50 (LITE) - [176x220](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.50_176.jar) | [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.50_240.jar)
    * New Character Arts from *Puyo Puyo Fever 2*!
    * New Title Screen Music from *Puyo Puyo Fever 2*!
    * Added "Enable Sounds" prompt message on boot.
    * Bug fixes.
* 10/04/2022: Ver. 2.00 (Public Beta Release) - [240x320 (WAV)](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.00_PublicBeta_WAV.jar) | [240x320 (AMR)](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.00_PublicBeta_AMR.jar)
    * New Town Map / Stage Select System.
    * New Menu / In-Game Graphics.
    * Variable Puyo Skins (Available in Gummy, Aqua (Default), Retro, and Fever) (It can be customized in settings).
    * Sound Effects and English/Japanese Voices (It can be changed in settings).
    * Major bug fixes.
* 10/13/2022: Ver. 1.41 (LITE) - [176x220](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.41_176.jar) | [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.41_240.jar)
    * Added 176x220 version
    * Some manzai dialog fixes.
    * Replaced BGM sounds to work on phones with 32-poly synth.
    * Bug fixes.
* 10/04/2022: Ver. 1.40 (LITE) - [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_LITE_1.40.jar)
    * Added new Main Menu background.
    * Added new softkey button sprite.
    * Retro Puyo skin is now replaced with Aqua Puyo skin.
    * Fixed All Clear / Fever / Nuisance Puyo drop speed.
    * QWERTY keyboard support.
    * Bug fixes.
* 05/25/2022: Ver. 1.21 - [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_1.21.jar)
    * Main Menu and In-Game GUI improvements from *Puyo Puyo Fever 2*.
    * Magic School Classroom background field improvement from *Puyo Puyo Fever 2*.
    * Fixed graphical glitches with puyo skins on CPU.
* 05/22/2022: Ver. 1.10 - [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_1.10.jar)
    * New character sprites from PPQ and PPT2!
    * New title screen from Puyo Puyo Fever Habanero with PPT2 Amitie!
    * Some bug fixes
* 05/14/2022: Ver. 1.00 - [240x320](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_1.00.jar)
    * Initial release

## Credits
**Project Leader** - [Realtimeless](https://github.com/Realtimeless785)

Custom **Gummy** Puyo Skin - Aburtos

**Portuguese** Translation - Obelisk

**Indonesian** Translation - ItzTools and [Realtimeless](https://github.com/Realtimeless785)

**Boilerplate J2ME project build** script - Nokia64

**Puyo Pop Fever Re:Chained** development - [Kahvibreak Discord server](https://discord.gg/8TgbHAG) and [English Puyo Puyo Community (EPPC) Discord server](https://discord.gg/Br4KqbR)
