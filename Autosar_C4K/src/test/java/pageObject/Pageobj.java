package pageObject;

import base.BaseClass;


public class Pageobj extends BaseClass {
	
	//Lunch Popup
	
	public static String workspaces = "Workspace:";
	public static String workspace = "//*[@Name='Workspace:']";
	public static String Launch ="OK";
	public static String Maximize = "//*[@LocalizedControlType='title bar']";
	public static String CloseButton = "Close";
	
	
	//C4K App
	
	public static String File = "File";
	public static String Import = "Import...";
	public static String Export = "Export...";
	public static String New = "New";
	public static String Project = "Project...";
	public static String Autosar = "AUTOSAR";
	public static String NewAutosar = "New AUTOSAR Project";
	public static String ProjectName = "Project name:";
	public static String C4K = "C4K";
	public static String DBC = "DBC"; 
	public static String Browse = "Browse...";
	public static String Properties_Tab = "Properties";
	public static String View_Menu = "View Menu";
	public static String CustomizeView = "Customize View...";
	public static String Resource = ".* resources";
	public static String HideECUParam = "Hide ECUC Parameters";
	public static String ECUDescription = "EcucDescription.arxml";
	public static String ECUDetailsTab = "ECUC Detail";
	public static String Merging_ECUC = "Merge ECU Extracts";
	public static String BSWMD_Folder = "bswmd";
	public static String Project_Folder = "AR1124";
	public static String Project_Folder_ = "AR1147";
	public static String Project_FolderIntergratorBswmd = "AR1128";
	public static String IntergratorBswmd = "AR1147";
	public static String BatchValidation = "Batch Validation";
	public static String ClearValidation = "Clear validation markers";
	public static String LocalParameters = "LocalParameters";
	public static String BswM_Module = "BswM_0 [BswM]";
	public static String Find_All_References = "Find all References";
	public static String AboutKsar = "About compose for K-SAR";
	public static String Strictmode = "Ecuc Strict Editing Mode";
	public static String MenuItem = "//*[@LocalizedControlType = 'menu item']";
	public static String Folder_Browse = "Folder:";
	public static String Generate_Button = "Generate";

	public static String Other = "Other...";
	public static String NewAUTOSARFile = "New AUTOSAR File";
	public static String CompareECUC = "Compare ECUC Extracts";
	public static String ModuleConfiguration  = "New Module Configuration";
	public static String AddElement = "/AUTOSAR/EcucDefs";
	public static String Autosar_KPIT ="/AUTOSAR/KPIT";
	public static String Autosar_Ecuc_Defs ="/KPIT/EcucDefs";
	public static String RteElement = "Rte";
	public static String Ote = "Os";
	public static String ARPackage = "ARRoot [ARPackage]";
	public static String CanMapping = "Can Hardware Object Mapping";
	public static String Generate_Code = "Generate Code";
	public static String Group_By = "Group By";
	
	public static String Project_PropertiesValidator = "AR1141";
	//public static String PropertiesCloseButton = "Close";
	public static String BlankWorkspaceArea = "SysTreeView32";
	public static String computeCanLabel = "compute Can";
	public static String Project_Folder1 = "AR1207";
	public static String ExitOption = "Exit";
	public static String ProjectFolderIOPT = "AR431";
	public static String IOPTFileName = "IOPT_minimal_system_desc.arxml";
	public static String ECU_ExtractOption = "ECU Extract";   
	public static String ECU_ExtraxtDisabledOption = "The chosen operation is not enabled."; 
	public static String CancelButton = "Cancel";  
	public static String ExportFileOption = "Export File";
	public static String ShowInSystemExplorerOption = "Show In SystemExplorer";
	public static String ProjectFolderECU = "AR1028";
	public static String ECUFileName = "EcucDescription.arxml";
	public static String ECUC_ARpackage = "EcucDescription [ARPackage]";   
	public static String DefaultSpace = "SWT_Window0";
	public static String EcuModulesFolder = "EcuC_0 [EcuC]";
	public static String EcuContainer = "EcucConfigSet_0 [EcucConfigSet]";
	public static String WorkspaceLabel = "TitleBar";
	public static String Project_FolderLabel = "AR842";
	public static String NoButton = "No";
	public static String YesButton = "Yes";
	public static String ECU_Report = "ECU Extract Report";


	
	//Bswmd Folder
	public static String ProjectFolderCreation = "Folder";
	public static String ProjectFolderName = "Folder name:";
	public static String IntegratorBswmdFolder = "integrator_bswmd";
	public static String BswmdFile = "Integrator_BswM_MD.arxml";
	public static String RenameOption = "Rename...";
	public static String RenameWithNewName = "New name:";
	public static String NewFolderName = "Inte";
	public static String MergeBswmdOption = "Merge BSWMD Files";
	public static String MergeBswmdOptionmessage = "Merge operation aborted; Reason: Selected folder 'integrator_bswmd' does not contain any arxml file.";
	
	

	//LDF_HCP_Extract
	
	
	//DBC

	public static String Dropdown = "ComboBox";
	public static String CMM ="CMM";
	public static String Select_All = "Select All";
	public static String Deselect_All = "Deselect All";
	public static String SwBaseType = "SwBaseType_SG_LEN_2_0_UNSIGNED [SwBaseType]";
	public static String SwBaseType16 = "SwBaseType_SG_LEN_16_0_SIGNED [SwBaseType]";
	public static String SwBaseType20 = "SwBaseType_SG_LEN_20_0_UNSIGNED [SwBaseType]";
	public static String BasicType = "Base Type Direct Definition [BaseTypeDirectDefinition]";
	public static String SetECu = "HCP";
	public static String SetECu2 = "BSM";
	
	
	//LDF
	
	public static String LDF = "LDF";
	public static String LDFBrowse = "Browse";
	public static String HCP = "HCP";
	public static String ECUC_Mapping = "ECUC Mapping";
	public static String COMModule = "Com_0 [Com]";
	public static String ComConfig = "ComConfig_0 [ComConfig]";
	public static String ComSignal = "ComSignal [96]";
	public static String SignalIPDU = "ISignalIPdu_AHP_REQ_GLOBAL_LIN_2_ISignal_AHP_FL_SAFE_ACTVT_LIN_2 [ComSignal]";
	public static String ComSignalEndianness = "ComSignalEndianness [EcucTextualParamValue]";
	public static String LITTLE_ENDIAN = "LITTLE_ENDIAN";
	
	//Import Popup
	
	public static String Edit = "Edit";
	public static String General_Folder = "General"; 
	public static String Existing_dir = "Existing Projects into Workspace";
	public static String Next_Button = "&Next  ";
	public static String Select_Root_dir = "Select root directory:";
	public static String TreeView32 = "SysTreeView32";
	public static String Finish_Button = "Finish";
	public static String FilePath = "File name:";
	public static String Open = "Open";
	public static String Native_Declaration = "Native Declaration";
	public static String Max_Base_Type_Size = "Max Base Type Size";
	public static String Import_FileSystem = "File System";
	public static String File_Directory = "From directory:";
	public static String CopyToProject = "Copy projects into workspace";
	public static String AcceptAgreementRadioButton  = "I accept the terms of the license agreement";
	public static String BaSIK_Addon = "BaSIK Addon";
	public static String Go_To_Reference_Object = "Go To Referenced Object";
	public static String BswMArPackage = "ArPackage_BswM [ARPackage]";
	public static String BswMService = "BswM [ServiceSwComponentType]";
	public static String BswMInternal = "IB_BswM [SwcInternalBehavior]";
	public static String DatatypeMapping = "Data Type Mappings";
	public static String LocalParameterForEcucDialog = "Local Parameters ECUC Mapping";
	public static String RetainConfiguration = "Retain Configuration";
	
	//File Click
	
	public static String default_arxml = "default.arxml";
	public static String EcucDescription_arxml = "Ecuc Description.arxml";
	
	//Data Mapping
	public static String Datamapping = "Data Mapping";
	public static String Drag = "SystemSignal_MMT_tx_200";
	public static String Drop = "ComM";
	public static String ClientServerPrimitiveTypeMapping ="Client Server Primitive Type Mapping [ClientServerPrimitiveTypeMapping]";
	public static String Sig_GrpV2G_PymntOptnLst = "SystemSignal_V2G_PymntOptnLst0";//SystemSignal_V2G_PymntOptnLst0
	public static String ChgIntf = "EcuM";
	public static String MCB_ECU_Extract = "MCB_ECU_Extract.arxml";
	public static String ASW = "ASW";
	public static String datamappingPackage = "datamapping [ARPackage]";
	public static String System_datamapping = "DataMapping_SystemMapping [System]";
	public static String Sender_Reciver = "Sender Receiver To Signal Mapping [SenderReceiverToSignalMapping]";
	public static String DataMapping_SystemMapping = "DataMapping_SystemMapping [SystemMapping]";
	
	//Click on Rte
	
	public static String Rte = "Rte_0 [Rte]";
	public static String Rtehover = "RteSwComponentInstance_1 [SwComponentPrototype]";
	public static String InternalTrigger = " [InternalTriggerOccurredEvent] [] ";
	public static String InternalEvent = "InternalTriggerOccurredEvent";
	public static String COMM_Impl_ComM_IB = "COMM_Impl_ComM_IB [COMM_Impl]";
	public static String ComM_MainFunction= "ComM_MainFunction_0 [BswTimingEvent] [ComM_MainFunction_0] [0.01]";
	//Context Click
	

	public static String Configure_Event_Mapping = "Configure Event Mapping";
	public static String RenameContext = "Rename...";
	public static String Renamefield ="New name:";
	//Module Definition

//	public static String Module_Defination = "Module Definitions";
//	public static String Module_Defination_File1 = "CanIf_BSWMD.arxml";
//	public static String Module_Defination_File2 = "CanNm_BSWMD.arxml";
//	public static String Merge_Files = "Merge Files";
	
	//Merge BSWMD Files
	
	public static String MergeBSWMDFiles = "Merge BSWMD Files";
	
	
	
	
	
	

	


    //Module Defination
    
    public static String Module_Defination = "Module Definitions";
    public static String Module_Defination_File1 = "CanIf_BSWMD.arxml";
    public static String Module_Defination_File5 = "EthTrcv_BSWMD.arxml";
    public static String Module_Defination_File2 = "CanNm_BSWMD.arxml";
    public static String Merge_Files = "Merge Files";
    public static String Module_Defination_File3 = "//*[@Name='ComXf_BSWMD.arxml']";
    public static String Module_Defination_File4 = "ListViewItem-14";
    
    
    //Export
    
    public static String Select_C4K = "C4K";
    public static String Export_SWC = "Export SWC";
    public static String Export_Project = "SWC_Export";
    public static String Export_File = "IOPT_minimal_system_desc.arxml";
    public static String SWC1 = "SWC1";
    public static String SWC2 = "SWC2";
    public static String Dir = "To directory:";
    
    		
    //Variable Access Point(1014)
    
    public static String Sib = "sib [SwcInternalBehavior]";
    public static String NewChild = "New Child";
    public static String Runnables = "Runnables";
    public static String Runnable_Entity = "Runnable Entity";
    public static String Created_Runnable = "RunnableEntity [RunnableEntity]";
    public static String Created_Runnable2 = "RunnableEntity_1 [RunnableEntity]";
    public static String Rename= "Rename";
   // public static String Rename_Input = "//*[not(contains(@Name,'Quick Access')) and (contains(@ClassName,'Edit'))]";
    public static String DSP = "Data Send Points";
    public static String Variable_Access = "Variable Access";
    public static String DRP_By_Arrgument = "Data Receive Point By Arguments";
    public static String Variable_child = "VariableAccess [VariableAccess]";
    public static String Save ="Save (Ctrl+S)";
    
    
    //Help
    public static String Help ="Help";
    public static String Help_Contents = "Help Contents";
    public static String JD_User_Guide = "Java development user guide";
    public static String Getting_Started = "Getting Started";
    public static String Basic_tutorial = "Basic tutorial";
    public static String Bookmark_Document = "Bookmark Document";
    public static String Bookmarks = "Bookmarks";
    public static String Window_Preferences = "Window > Preferences...";
    public static String Titlebar = "//*[@LocalizedControlType ='title bar']";
    public static String PreparingEclipse = "Preparing Eclipse";
    public static String Search_Field = "Search:";
    public static String Go_Button = "Go";
    public static String Print_page = "Print Page";
    public static String Creating_your_first_Java_project = "Creating your first Java project";
    public static String InstalNewSoftwareOption = "Install New Software...";
    public static String AddButton = "Add...";
    public static String LocalButton = "Local...";
    public static String LocationTextbox = "Location:";
    public static String InstallationDetails_Option = "Installation Details";
    public static String Basikaddonfeature_option = "Basikaddonfeature";
    public static String UnistallButton = "Uninstall...";
    public static String BasikMenuItem = "//[@LocalizedControlType ='menu item']";
    public static String communicationOption = "Communication";
    public static String communicationOptionCom = "COM";
    public static String Diagnosticoption = "Diagnostic";
    public static String DiagnosticoptionDCM = "DCM";
    public static String DiagnosticoptionDEM = "DEM";
    public static String BuildAcceleratorOption = "Build Accelerator";
    public static String BuildAcceleratorOCMExtracter = "OEM Extractor";
    public static String BuildAcceleratorMemmap = "Memmap";
    public static String MemoryOption = "Memory";
    public static String MemoryOptionNvm = "NvM";
    
    
 
    //Cheat Sheet
    public static String CheatsheetOption ="Cheat Sheets...";
    public static String QuickAccessTextbox ="Quick Access";
    public static String Compose4KsarCheatsheetFolder ="Compose4Ksar";
    public static String Compose4KsarCheatsheetLabel ="Compose for K-SAR";
    public static String CheatSheetsTab ="Cheat Sheets";
    public static String QuickAccessMenus ="Menus";
    public static String AutosarProjectCreationLabel ="AUTOSAR Project Creation and Configuration";
    public static String StartWorkingLabel =" Start working on this task";
    public static String IntroductionLabel ="Introduction";
    public static String OpenTheComposeLabel ="Open the Compose Perspective";
    public static String CreateAUTOSARLabel ="Create AUTOSAR Project";
    public static String NewAUTOSARFileLabel ="Create a new AUTOSAR file";
    public static String ModuleConfigurationLabel ="New Module Configuration";
    public static String ClickToBeginLabel ="Click to Begin";
    public static String ClickToPerformLabel ="Click to perform";
    public static String ClickToSkipLabel ="Click to skip";
    public static String NextTaskLabel ="//*[@LocalizedControlType='edit']";
    public static String ClickWhenCompleteLabel ="//*[@LocalizedControlType='link']";
    public static String GettingStartedOption ="Getting Started With C4K";
    public static String RestartAllTaskOption ="Restart all tasks";
    public static String ResetOption ="Reset";
    
    
    //Can
    
    public static String EnterCanController = "Enter the number of CAN Controller";
    public static String Modify = "Modify";
    
    //PCCR
    public static String PccrGenerateCode = "Generate Code";
    public static String MemifOption = "MemIf_0 [/AUTOSAR/EcucDefs/MemIf]";
    public static String Output_LocationTextbox = "Output Location";
    public static String PreCompile_Check_Option = "Pre-Compile Check Remover Tool Feature";
    public static String uninstall_Check_Option = "BSW DET";
    public static String EcuExtractFileName = "EcuExtract_20210428192158.arxml";
    public static String DB_ECU_LeftLampCMD = "DB_ECU_LeftLampCMD [SystemSignalGroup]";
    public static String VariationpointOption = "Variation Point [VariationPoint]";
    public static String CopyOption = "Copy";
    public static String ALS_CMD = "ALS_CMD [SystemSignalGroup]";
    public static String PasteOption = "Paste";
	
}
