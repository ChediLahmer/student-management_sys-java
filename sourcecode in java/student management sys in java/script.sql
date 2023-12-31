USE [studentmanagementsys]
GO
/****** Object:  Table [dbo].[Absence]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Absence](
	[idetudiant] [int] NOT NULL,
	[idenseignant] [int] NOT NULL,
	[idmatiere] [int] NOT NULL,
	[numseance] [int] NOT NULL,
	[date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idetudiant] ASC,
	[idenseignant] ASC,
	[idmatiere] ASC,
	[numseance] ASC,
	[date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Classe]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Classe](
	[idclasse] [int] NOT NULL,
	[libelle] [varchar](255) NULL,
	[niveau] [varchar](255) NULL,
	[filiere] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idclasse] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Correspondance]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Correspondance](
	[idenseignant] [int] NOT NULL,
	[id_matiere] [int] NOT NULL,
	[id_classe] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idenseignant] ASC,
	[id_matiere] ASC,
	[id_classe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Enseignant]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Enseignant](
	[idenseignant] [int] NOT NULL,
	[nom] [varchar](255) NULL,
	[prenom] [varchar](255) NULL,
	[login] [varchar](255) NULL,
	[pwd] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idenseignant] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Etudiant]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Etudiant](
	[idetudiant] [int] NOT NULL,
	[nom] [varchar](255) NULL,
	[prenom] [varchar](255) NULL,
	[login] [varchar](255) NULL,
	[pwd] [varchar](255) NULL,
	[idclasse] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idetudiant] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Matiere]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Matiere](
	[idmatiere] [int] NOT NULL,
	[libelle] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idmatiere] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Responsable]    Script Date: 1/7/2023 8:30:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Responsable](
	[idresponsable] [int] NOT NULL,
	[nom] [varchar](255) NULL,
	[prenom] [varchar](255) NULL,
	[login] [varchar](255) NULL,
	[pwd] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idresponsable] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Absence]  WITH CHECK ADD FOREIGN KEY([idenseignant])
REFERENCES [dbo].[Enseignant] ([idenseignant])
GO
ALTER TABLE [dbo].[Absence]  WITH CHECK ADD FOREIGN KEY([idetudiant])
REFERENCES [dbo].[Etudiant] ([idetudiant])
GO
ALTER TABLE [dbo].[Absence]  WITH CHECK ADD FOREIGN KEY([idmatiere])
REFERENCES [dbo].[Matiere] ([idmatiere])
GO
ALTER TABLE [dbo].[Correspondance]  WITH CHECK ADD FOREIGN KEY([id_classe])
REFERENCES [dbo].[Classe] ([idclasse])
GO
ALTER TABLE [dbo].[Correspondance]  WITH CHECK ADD FOREIGN KEY([idenseignant])
REFERENCES [dbo].[Enseignant] ([idenseignant])
GO
ALTER TABLE [dbo].[Correspondance]  WITH CHECK ADD FOREIGN KEY([id_matiere])
REFERENCES [dbo].[Matiere] ([idmatiere])
GO
ALTER TABLE [dbo].[Etudiant]  WITH CHECK ADD FOREIGN KEY([idclasse])
REFERENCES [dbo].[Classe] ([idclasse])
GO
