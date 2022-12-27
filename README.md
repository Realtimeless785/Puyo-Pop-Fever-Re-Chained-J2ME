# Puyo Pop Fever Re:Chained (Java ME / J2ME)
![Puyo Pop Fever Re:Chained (English) Logo](https://user-images.githubusercontent.com/117650736/200515284-f211b9f1-b663-485d-8ee9-482bc131e9a5.png)

Other logos: [Puyo Pop Fever Re:Chained LITE](https://user-images.githubusercontent.com/117650736/204701467-0ec12a64-3c5c-4c0a-99f1-dbbe2a4da070.png) | 
[ぷよぷよフィーバーRe:れんさ (Japanese)](https://user-images.githubusercontent.com/117650736/204701425-354a7380-f844-4c3e-8bc6-b8fe8205b8fc.png)


**Puyo Pop Fever Re:Chained** is a modified version of the Puyo Puyo Fever DX (J2ME, Chinese ForceGen Version) mobile game with many features, major improvements, and implementations. This mod will give you a *Puyo Puyo Fever 2*-like experience with the original Puyo Puyo Fever storylines.

This mod includes 2 versions, the **FULL** version and the low-end or stripped down version called the **LITE** version. The FULL version bundled with 2 variants with the SFX audio type, `WAV` and `AMR`. The `AMR` variant supports for most devices, but it has lower-quality SFX, while the `WAV` variant supports for some devices with higher-quality SFX (11025 Hz) and lower latency (Depends on the phone's CPU).

## ![Features and Improvements](https://user-images.githubusercontent.com/117650736/204738220-9d333d89-8b30-40aa-b98a-7c4a4777f716.png)
![PuyoFever_ReChained_Ver_2 00_Final_Screenshots](https://user-images.githubusercontent.com/117650736/201877391-5364ce52-541b-4980-b00f-3efdc0d78e52.png)

**The FULL version includes many features:**
* **NEW** Town Map / Stage Select System,
* **NEW** Menu / In-Game Graphics,
* **NEW** Sound Effects and English/Japanese Voices (Changeable in settings),

* **Customizable** In-Game Background Themes (Available in `Pink` (Default), `Blue`, `Orange`, and `Original Fever`),

![PuyoFever_ReChained_Ver_2 00_Final_InGameBgThemes](https://user-images.githubusercontent.com/117650736/201873162-7fc3dc1b-4f33-49b5-868a-306aaa8f471f.png)
 
* **Customizable** Puyo Skins (Available in `Gummy`, `Aqua` (Default), `Retro`, `Fever`, and `Classic`),

![puyopreview_gummy](https://user-images.githubusercontent.com/117650736/201870118-31456182-e8b6-46b3-942b-ac5c0ca63c52.png) ![puyopreview_aqua](https://user-images.githubusercontent.com/117650736/201870282-2ef3943b-5938-4122-a331-352e152569f2.png) ![puyopreview_retro](https://user-images.githubusercontent.com/117650736/201870341-aa8fd942-23a2-4cc3-88c4-8777785a3a8a.png) ![puyopreview_fever](https://user-images.githubusercontent.com/117650736/201870372-633a6ffe-89ab-49af-bb4e-630f4ccf4980.png) ![puyopreview_classic](https://user-images.githubusercontent.com/117650736/201870397-217be90a-4d82-4fb4-8441-4ea942e5fc90.png) 

* Supports for **multiple resolutions** and **Auto-Adjust** screen resolution feature (`240x320`, `352x416`, `400x240`, `640x360`, `800x352`, and more!),

![image](https://user-images.githubusercontent.com/117650736/201683796-ecf609fd-a3cd-4d65-81f8-08f800d848b2.png)

* **QWERTY** keyboard support, and
* **Major** bug fixes.

However, the FULL version only works with higher-end J2ME-enabled phones with more than `64KB` of maximum heap size limit (e.g. Nokia S40v6 with 1GHz CPU, Nokia/SE Symbian, Sony Ericsson, Samsung, LG, Motorola) and most J2ME emulators (e.g FreeJ2ME/ J2ME Loader / JL-Mod, KEmulator Lite 0.9.3 / 0.9.7 / 0.9.8 / 1.0.3 / nnmod). This version is NOT compatible with lower-end Samsung, LG, Motorola, Nokia S40v3/v4/v5/v6, and other phones with 32KB of maximum heap size limit.

![PuyoFever_ReChained_LITE_Ver_1 50_240x320_Screenshots](https://user-images.githubusercontent.com/117650736/201879385-7613fc36-5c18-46c9-ac9a-bd23361e1a7c.png)

**The LITE version lacks some features:**
* No Town Map / Stage Select System,
* No Sound Effects and Voices,
* Simplified Menu,
* Only one Puyo skin available is `Aqua`, and
* Only one in-game background theme available is `Pink`.

This version supports most lower-end Samsung, LG, Motorola, Nokia S40v3/v4/v5/v6, and other phones with more than `32KB` of maximum heap size limit. 

## ![In-Game Controls](https://user-images.githubusercontent.com/117650736/204738418-261c9f07-673c-43cc-ba3a-2bb410b6df9c.png)
* **Phone Keypad:**
    * Move Puyo Left (←) = `Left D-Pad` / `4`
    * Move Puyo Right (→) = `Right D-Pad` / `6`
    * Rotate Puyo Left (↑) = `Up D-Pad` / `2`
    * Rotate Puyo Right (Select) = `OK` / `5`
    * Drop Puyo Faster (↓) = `Down` / `8`
    * Left Softkey = LSK
    * Right Softkey = RSK
* **QWERTY Keypad:**
    * Move Puyo Left (←) = `A`
    * Move Puyo Right (→) = `D`
    * Rotate Puyo Left (↑) = `W` / `,`
    * Rotate Puyo Right (Select) = `Enter`
    * Drop Puyo Faster (↓) = `S`
    * Left Softkey = `Shift`
    * Right Softkey = `Backspace`

## ![Supported Screen Resolutions](https://user-images.githubusercontent.com/117650736/204738489-9e0886b5-2cfc-4dfe-943e-e3001d96a0d8.png)
* **Puyo Pop Fever Re:Chained**
    * `240x320` (Tested on: Alcatel ED782A | Motorola RAZR2 V8/VE66 | Nokia 6210s/5320 XM/E52/E90/N73/N79/N81/N85/N93/N95 | SE K800i/K810i/K850i/W20/W508/W890i)
    * `240x400` (Tested on: LG C395)
    * `240x432` (Tested on: SE U10i)
    * `352x416` (Tested on: Nokia E70)
    * `400x240`
    * `640x360`* (Tested on: Nokia C6-00/C7-00 | N97)
    * `640x480`* (Tested on: Nokia E6-00)
    * `800x352`* (Tested on: Nokia E90)
    * `800x480`*
    * `480x800`*
    * `480x854`*
* **Puyo Pop Fever Re:Chained LITE**
    * `176x208` (Tested on: Nokia 3230/6680/N70)
    * `176x220` (Tested on: LG B470/C441/LG440G | SE W660i/Z550i)
    * `220x176` (Tested on: Alcatel OT-871A)
    * `240x320` (Tested on: Huawei C6100 | LG CU720/KE970/KF600 | Nokia 2730c/5310 XM/6233/6275i/6300/6350/6500s/7100s/7230s/7610s/C2-01/C2-02 | Samsung GT-S5603/SGH-D830/SGH-U800/SPH-A900)
    * `240x400` (Tested on: LG GD570)
    * `240x432` (Tested on: SE U10i)
    * `320x240` (Tested on: Nokia 200/C3-00/E63/E71/X2-01/Nokia X5-01)
    * `352x416` (Tested on: N80, E70)
    * `400x240`

(*) Automatically changes the softkey buttons layout

## ![Compatibility Issues](https://user-images.githubusercontent.com/117650736/204738545-59d5f4c6-6238-4d85-98f0-8e2042c5405b.png)
![image](https://user-images.githubusercontent.com/117650736/201681843-d287845a-cbce-423d-a1cc-60348379d2f7.png)

* If you experience a problem while loading sound effects (e.g. Out of Memory error), you can press both `Left` and `Right` D-Pad or `4` and `6` key repeatedly at the *SEGA / SONIC TEAM* splash screen until the red **[!] SFX Disabled** message will appear on the splash screen. This will disable the SFX functionallity and greatly reduces loading times and memory usage.

(This feature is present for the **FULL** version only, since Ver. 2.00 Final Release).

* If the game doesn't work on some phones, use the `Java Adapter for Mobile Expert Edition / JAM EE` adapter tool to make workaround.

* Touchscreen support is *currently* not supported yet. Alternatively, you can use the `Java Adapter for Mobile Expert Edition / JAM EE` adapter tool to add touchscreen support by yourself.

## ![Source Code Release](https://user-images.githubusercontent.com/117650736/204738594-f9f5ff41-6722-4625-a223-ecefcbbe94c4.png)
The source code for both of the Puyo Pop Fever Re:Chained and Puyo Pop Fever Re:Chained LITE has been released and the source codes are usable for now.

Both of these source codes included with Boilerplate J2ME project build script made by Nokia64.

You can get the [source code](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/tree/main/Source%20Codes) here.

Feel free to implement some new features or mod the game by yourself! :)

## ![Release Changelogs & Download](https://user-images.githubusercontent.com/117650736/204738631-27190ec7-d59b-41ec-bc55-9ecfe3e980f1.png)
*Latest version:*

* 11/30/2022: **Ver. 2.01** - English ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_en_US_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_en_US_Release_AMR.jar)) | Portuguese ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_pt_BR_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_pt_BR_Release_AMR.jar)) | Bahasa Indonesia ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_id_ID_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_id_ID_Release_AMR.jar)) | Chinese ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_zh_CN_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_zh_CN_Release_AMR.jar)) | Japanese ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_ja_JP_Release_WAV.jar) / [AMR](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_ja_JP_Release_AMR.jar))
    * **UPDATE 12/27/2022:** Added japanese language in this version, it is recommended to set the font size to 14 on the JP version.
    * Added other languages: Portuguese, Indonesian, and Chinese.
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

*Experimental releases:*

* 12/19/2022: **Ver. 2.01** Debug Build - English ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Pop_Fever_ReChained_2.01_en_US_Debug_WAV.jar)) | Japanese ([WAV](https://github.com/Realtimeless785/Puyo-Pop-Fever-Re-Chained-J2ME/raw/main/Releases/Puyo_Puyo_Fever_ReChained_2.01_ja_JP_Debug.jar))
    * To enable debug mode, you need to press the `Right Softkey (RSK)` button repeatedly at the *SEGA / SONIC TEAM* splash screen until the **Debug Mode** message will appear on the loading screen for a split second and then displays **verbose** status messages while loading the game data.
    * In debug mode, you can press the `OK / 5` key at the pause screen to jump straight into the debug menu screen and pressing the `Right Softkey (RSK)` at in-game, you'll instantly get fever mode.

      ![Verbose Loading Messages](https://user-images.githubusercontent.com/117650736/208330007-3ca4b7a6-36cd-4438-9ea6-ce31c67acb4c.png) ![Debug Menu](https://user-images.githubusercontent.com/117650736/208329460-6e5704cc-5622-4c78-999b-732b4a46c843.png) ![Game Menu (Debug)](https://user-images.githubusercontent.com/117650736/208329755-bbdd728a-85e7-4f2a-900f-747f61b190a5.png)





## ![Credits](https://user-images.githubusercontent.com/117650736/204738709-0eba7dcc-518e-4bef-a9c5-a83d7224c501.png)
**Project Leader** - [Realtimeless](https://github.com/Realtimeless785)

Custom `Gummy` Puyo Skin - Aburtos

`Portuguese (PT)` translation - magolor and Obelisk

`Indonesian (ID)` translation - ItzTools and [Realtimeless](https://github.com/Realtimeless785)

`Japanese (JP)` translation - ThanhPhuc

`Boilerplate J2ME project build` script - Nokia64

**Puyo Pop Fever Re:Chained** development - [Kahvibreak Discord server](https://discord.gg/8TgbHAG) and [English Puyo Puyo Community (EPPC) Discord server](https://discord.gg/Br4KqbR)
